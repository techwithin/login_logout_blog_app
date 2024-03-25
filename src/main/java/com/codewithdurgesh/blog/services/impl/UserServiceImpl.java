package com.codewithdurgesh.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.entities.Role;
import com.codewithdurgesh.blog.entities.User;
import com.codewithdurgesh.blog.exceptions.ResourceNotFoundException;
import com.codewithdurgesh.blog.payloads.UserDto;
import com.codewithdurgesh.blog.repositories.RoleRepo;
import com.codewithdurgesh.blog.repositories.UserRepo;
import com.codewithdurgesh.blog.services.UserService;
@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;
	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.UserToUserDTo(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User Id",userId));
		System.out.println("1");
		//user.setId(userDto.getId());
		System.out.println("1");
		user.setName(userDto.getName());
		System.out.println("1");
		user.setEmail(userDto.getEmail());
		
		System.out.println("1");
		user.setAbout(userDto.getAbout());
		System.out.println("1");
		user.setPassword(userDto.getPassword());
		System.out.println("1");
		User savedUser = this.userRepo.save(user);
		System.out.println("1");
		return this.UserToUserDTo(savedUser);
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User Id",userId));
		return this.UserToUserDTo(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDto>userDtos=users.stream().map(user -> this.UserToUserDTo(user)).collect(Collectors.toList());
		// TODO Auto-generated method stub
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User Id",userId));
		this.userRepo.delete(user);
	}
	
	private com.codewithdurgesh.blog.entities.User dtoToUser(UserDto userDto) {
		User user  = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		return user;
	}
	
	private UserDto UserToUserDTo(User userDto) {
		UserDto user  = new UserDto();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		return user;
	}

	@Override
	public UserDto registerNewUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);

		// encoded the password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		// roles
		Role role = this.roleRepo.findById(2).get();

		user.getRoles().add(role);

		User newUser = this.userRepo.save(user);

		return this.UserToUserDTo(newUser);
	}
	
	
	

}
