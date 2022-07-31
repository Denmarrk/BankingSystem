package com.example.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Transac.Transact;
import com.example.demo.domain.AdminLogin;


@Repository
public interface LoginRepository extends JpaRepository<AdminLogin, Long>{
	AdminLogin findByUsernameAndPassword (String username,String password);

	AdminLogin findByAccountnumber(String accountnumber);

	


}
