package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.LoginRepository;
import com.example.demo.Transac.Transact;
import com.example.demo.domain.AdminLogin;

@Service
public class LoginService  {
	@Autowired
	private LoginRepository repo;
	
	public AdminLogin loginrepo(String username, String password) {
		
		AdminLogin user = repo.findByUsernameAndPassword(username, password);
	
		return user;
	
	}

	public AdminLogin getaccount(String accountnumber) {
		AdminLogin account = repo.findByAccountnumber(accountnumber);
		return account;
	}
	
	
	
	
}
