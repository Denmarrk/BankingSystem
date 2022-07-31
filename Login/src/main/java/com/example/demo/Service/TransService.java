package com.example.demo.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Repository.transRepo;
import com.example.demo.Transac.Transact;
@Service
@Transactional
public class TransService {
	
	@Autowired
	private transRepo repo;
	
	public List<Transact> getTransact(String fromaccountnumber){
		return repo.findByFromaccountnumber(fromaccountnumber);
	}

}
