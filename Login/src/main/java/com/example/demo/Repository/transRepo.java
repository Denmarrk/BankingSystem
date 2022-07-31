package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Transac.Transact;


@Repository
public interface transRepo extends JpaRepository<Transact, Integer>{

	List<Transact> findByFromaccountnumber(String fromaccountnumber);



}
