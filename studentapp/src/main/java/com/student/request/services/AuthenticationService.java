package com.student.request.services;

import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.student.request.Exception.CustomException;
import com.student.request.models.UserModel;
import com.student.request.modelsDto.SignUpResponse;
import com.student.request.modelsDto.UserDto;
import com.student.request.repository.UserRepository;


@Service
public class AuthenticationService {
	
	@Autowired
	UserRepository authrepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@Transactional
	public SignUpResponse saveUser(UserDto userdto) {
		
		//check if the user is already present
		if(Objects.nonNull(authrepo.findByEmail(userdto.getEmail()))) {
			//we have an user
			throw new CustomException("User already present");
		}
	
		//hash the password BCryptPasswordEncoder
		String encryptedpassword = getEncodedPassword(userdto.getPassword());

		//save the user
		UserModel submituser = new UserModel(userdto.getUserRole(), userdto.getEmail(), userdto.getUsername(), 
				userdto.getMobileNumber(), encryptedpassword, encryptedpassword);
		
		
		authrepo.save(submituser);
		
		
		SignUpResponse response = new SignUpResponse("success", "User added");
		return response;
	}
	

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
   
	

}
