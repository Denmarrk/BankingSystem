package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.UserRepository;



import com.example.demo.Main.UserMain;
@Service
public class UserService {
	
	@Autowired
	private UserRepository  userRepository;
	
	public UserMain saveUserMain(UserMain useraccount) {
		return userRepository.save(useraccount);	
	}
	
	public List<UserMain> saveUserMains(List<UserMain> useraccount) {
		return userRepository.saveAll(useraccount);
	}
	
	
	public List<UserMain> getUserMain(){
		return userRepository.findAll();
		
	}
	
	public UserMain getUserMainByUserId(int Id) {
		return userRepository.findById(Id).orElse(null);
		
	}
	public UserMain getUserMainByAccountNumber(int accountnumber) {
		return userRepository.findByAccountnumber(accountnumber);
		
	}
	public UserMain getUserMainByFirstName(String firstname) {
		return userRepository.findByFirstname(firstname);
		
	}
	
	public UserMain getUserMainByLastName(String lastname) {
		return userRepository.findByLastname(lastname);
		
	}
	
	public UserMain getUserMainByuserName(String username) {
		return userRepository.findByUsername(username);
		
	}
	
	public String DeleteUser(int Id ) {
		userRepository.deleteById(Id);
		return "User Is removed !!" +Id;
				
	}
	
	public UserMain updateUser(UserMain useraccount) {
		UserMain existingUser= userRepository.findById(useraccount.getId()).orElse(null);
		existingUser.setFirstname(useraccount.getFirstname());
		existingUser.setLastname(useraccount.getLastname());
		existingUser.setUsername(useraccount.getUsername());
		
		return userRepository.save(existingUser);
	}
	
	public UserMain updateUsers(String accountnumber,UserMain useraccount) {
		UserMain existingUser= userRepository.findByAccountnumber(useraccount.getAccountnumber());
		existingUser.setTotalbalance(useraccount.getTotalbalance());
	
		
		return userRepository.save(existingUser);
	}

	public UserMain updateUsers1(UserMain useraccount) {
		UserMain existingUser= userRepository.findByAccountnumber(useraccount.getAccountnumber());
		existingUser.setTotalbalance(useraccount.getTotalbalance());
	
		
		return userRepository.save(existingUser);
	}

	
	
	   
	
	
	
}
