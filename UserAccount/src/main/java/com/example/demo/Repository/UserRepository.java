package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Main.UserMain;


@Repository
public interface UserRepository extends JpaRepository<UserMain,Integer > {

	UserMain findByAccountnumber(int accountnumber);



UserMain findByFirstname(String firstname);
UserMain findByLastname(String lastname);
UserMain findByUsername(String username);



UserMain findByAccountnumber(String accountnumber);
	
	

}
