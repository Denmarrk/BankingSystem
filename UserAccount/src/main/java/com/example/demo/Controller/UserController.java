package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Main.UserMain;
import com.example.demo.Service.UserService;

@RestController
@RequestMapping("/Account")
public class UserController {
	
	@Autowired 
	private UserService  userService;
	
	@PostMapping("/adduser")
	public UserMain addUser(@RequestBody UserMain useraccount) {
		return userService.saveUserMain(useraccount);
	}
	
	@PostMapping("/addusers")
	public List<UserMain>  addUsers(@RequestBody List<UserMain> useraccount) {
		return userService.saveUserMains(useraccount);
	}
	
	
	@GetMapping("/users")
	public List<UserMain> findAllUser(){
		return userService.getUserMain() ;
		
	}
	
	@GetMapping("/user1/{id}")
	public UserMain findUserByID(@PathVariable int Id){
		return userService.getUserMainByUserId(Id) ;
		
	}
	
	@GetMapping("/user2/{accountnumber}")
	public  UserMain findByaccountnumber(@PathVariable int accountnumber) {
		return userService.getUserMainByAccountNumber(accountnumber);
		
	}
	
	@GetMapping("/user3/{firstname}")
	public  UserMain findByFirstName(@PathVariable String firstname) {
		return userService.getUserMainByFirstName(firstname);
	}
	
	@GetMapping("/user4/{lastname}")
	public  UserMain findByLastName(@PathVariable String lastname) {
		return userService.getUserMainByLastName(lastname);
	}
	
	
	@GetMapping("/user5/{username}")
	public UserMain findbyUsername(@PathVariable String username) {
		return userService.getUserMainByuserName(username);
		
	}
	
	
	@PutMapping("/updates")
	public UserMain updateUser(@RequestBody UserMain useraccount) {
		return userService.updateUsers1(useraccount);
	}
	
	
	@PutMapping("/update")
	public UserMain updateUsers(@RequestBody UserMain useraccount) {
		return userService.updateUsers1(useraccount);
		
	}
	//@PathVariable("accountnumber") String accountnumber,
	
	@DeleteMapping("/delete")
	public String deleteuser(@PathVariable int Id) {
		 userService.DeleteUser(Id);
		 return "Deleted ID";
		
		
	}
	
	
	

}
