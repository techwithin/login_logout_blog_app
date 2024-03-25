package com.codewithdurgesh.blog.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<com.codewithdurgesh.blog.entities.User, Integer> {
	Optional<com.codewithdurgesh.blog.entities.User> findByEmail(String email);

}
