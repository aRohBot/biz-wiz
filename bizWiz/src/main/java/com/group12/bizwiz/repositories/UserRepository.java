package com.group12.bizwiz.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.group12.bizwiz.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
	//when would we use <Optional> User versus User ?
		//we dont need to add anything to repository to add on likes
	List<User> findAll();
	User findByIdIs(Long id);
}