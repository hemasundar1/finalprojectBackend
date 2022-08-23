package com.student.request.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.request.modelsDto.SignUpResponse;
import com.student.request.modelsDto.UserDto;
import com.student.request.services.AuthenticationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthController {


	@Autowired
	AuthenticationService authService;
	
	@PostMapping("/user/signup")
	public SignUpResponse saveUser(@RequestBody UserDto user) {
		return authService.saveUser(user);
	}
	

 


}
