package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.LoginRepository;

import com.example.demo.domain.UserLogin;


@Service
public class LoginService  {
	@Autowired
	private LoginRepository repo;
	
	public UserLogin loginrepo(String username, String password) {
		
		UserLogin user = repo.findByUsernameAndPassword(username, password);
	
		return user;
	
	}

	public UserLogin getaccount(String accountnumber) {
		UserLogin account = repo.findByAccountnumber(accountnumber);
		return account;
	}

	public List<UserLogin> getNewList(String contactnumber, String firstname, String lastname) {
		// TODO Auto-generated method stub
		return repo.findByContactnumberAndFirstnameAndLastname(contactnumber,firstname,lastname );
	}
	
	
	
	
}
