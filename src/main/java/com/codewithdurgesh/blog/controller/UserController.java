package com.codewithdurgesh.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithdurgesh.blog.payloads.ApiResponse;
import com.codewithdurgesh.blog.payloads.UserDto;
import com.codewithdurgesh.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	@PostMapping("/")
	public ResponseEntity<UserDto>createUser(@RequestBody UserDto userDto){
		
		System.out.print("IDHAR AAYA ------>");
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto>updateUser(@RequestBody UserDto userDto, @PathVariable int userId){
		
	
		UserDto updatedUserDto = this.userService.updateUser(userDto,userId);
		//return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		return ResponseEntity.ok(updatedUserDto);
	}
	//ADMIN
		// DELETE -delete user
		@PreAuthorize("hasRole('ADMIN')")
		@DeleteMapping("/{userId}")
		public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid) {
			this.userService.deleteUser(uid);
			return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
		}

	// GET - user get
		@GetMapping("/")
		public ResponseEntity<List<UserDto>> getAllUsers() {
			return ResponseEntity.ok(this.userService.getAllUsers());
		}

		// GET - user get
		@GetMapping("/{userId}")
		public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId) {
			return ResponseEntity.ok(this.userService.getUserById(userId));
		}

}
