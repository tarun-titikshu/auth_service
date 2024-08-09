package com.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.repository.UserRepository;

@Service
public class AuthServiceImpl {
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private PasswordEncoder passencoder;
	
	
	

}
