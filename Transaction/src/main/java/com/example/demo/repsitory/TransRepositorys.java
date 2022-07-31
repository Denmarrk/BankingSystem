package com.example.demo.repsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Transac.Transact;


@Repository
public interface TransRepositorys extends JpaRepository<Transact, Integer>{

	//Transact Fromaccountnumber(String fromaccountnumber);
	List<Transact> findByFromaccountnumber(String fromaccountnumber);
	//Transact findByFromaccountnumber(String fromaccountnumber);


	



}
