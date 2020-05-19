package com.example.demo.controller;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/users")
	public User Create(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PostMapping("/allusers")
	public List<User> allusers(){
		System.out.println(userRepository.findAll());
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		User user = userOptional.orElseThrow(
				()-> new ResourceNotFoundException("User","ID",id));
		
		return user;
	}
	
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User userDetail) {
		User user = userRepository.findById(id)
						.orElseThrow(()->new ResourceNotFoundException("User","ID",id));
		user.setName(userDetail.getName());

		User updatedUser = userRepository.save(user);
		
		return updatedUser;
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		Optional<User> optUser =  userRepository.findById(id);
		
		if(!optUser.isPresent()) {
			return new ResponseEntity<String>(id+" not found", HttpStatus.NOT_FOUND);
		}
		
		userRepository.deleteById(id);

		return new ResponseEntity<String>("Delete ok",HttpStatus.OK);
	}
}
