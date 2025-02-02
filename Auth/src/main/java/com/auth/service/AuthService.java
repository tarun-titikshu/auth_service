package com.auth.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.dto.LoginRequest;
import com.auth.dto.SignupRequest;
import com.auth.dto.UserDTO;
import com.auth.model.User;
import com.auth.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	public UserRepository userrepo;
	
	@Autowired
	public PasswordEncoder passencoder;
	
	public UserDTO registerUser(SignupRequest signupRequest) {
        Optional<User> existingUser = userrepo.findByEmail(signupRequest.getEmail());
        if(existingUser.isPresent()) {
            throw new RuntimeException("Email is already taken!");
        }
        
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setPassword(passencoder.encode(signupRequest.getPassword()));
        user.setRole(signupRequest.getRole());
        
        userrepo.save(user);
        
		return new UserDTO(user.getId(),user.getEmail(),user.getRole());

	}
	
	public UserDTO authenticateUser(LoginRequest loginrequest) {
		
		User user = userrepo.findByEmail(null) .orElseThrow(() -> new RuntimeException("Invalid credentials"));
		
		if(!passencoder.matches(loginrequest.getPassword(),user.getPassword())) {
			throw new RuntimeException("Invalid Crededntials!");
		}
		
		 return new UserDTO(user.getId(), user.getEmail(), user.getRole());
		
	}

//	public Object loadUserByUsername(String email) {
//		// TODO Auto-generated method stub
//		return email;
//	}
	
	
	
	
	
}
