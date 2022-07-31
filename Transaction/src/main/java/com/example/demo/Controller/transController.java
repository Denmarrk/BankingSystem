package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Transac.Transact;
import com.example.demo.service.service;
@RestController
@RequestMapping("/transact")
public class transController {
	@Autowired 
	private service  userService;
	
	@PostMapping("/addtransact")
	public Transact addUser(@RequestBody Transact Transact) {
		return userService.saveTransact(Transact);
	}
	
 
	  
//	@GetMapping("/user1/{fromaccountnumber}")
//	public Transact findUserByFromaccountnumber(@PathVariable String fromaccountnumber){
	//	return userService.findbyFromaccountnumber(fromaccountnumber) ;
		
//}
	
	@GetMapping("/user1/{fromaccountnumber}")
	public List<Transact> findUserByFromaccountnumber(@PathVariable String fromaccountnumber){
		return userService.getTransact(fromaccountnumber);
			
}
	
//	@GetMapping("/user1/{fromaccountnumber}")
	//public  Transact findUserByFromaccountnumber(@PathVariable String fromaccountnumber){
	//	return userService.getTransact(fromaccountnumber);
			
//}
	

}
