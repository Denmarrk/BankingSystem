package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.Transac.Transact;
import com.example.demo.repsitory.TransRepositorys;

@Service
public class service {
	@Autowired
	private TransRepositorys repo;
	
	public Transact saveTransact(Transact transact) {
		return repo.save(transact);	
	}
	
//public Transact findbyFromaccountnumber(String fromaccountnumber)
//{
//	return repo.Fromaccountnumber(fromaccountnumber);
	
//}

	public List<Transact> getTransact(String fromaccountnumber){
		return repo.findByFromaccountnumber(fromaccountnumber);
		
	}
	
	//public Transact getTransact(String fromaccountnumber){
	//	return repo.findByFromaccountnumber(fromaccountnumber);
		
	



	
	

		
	
}
