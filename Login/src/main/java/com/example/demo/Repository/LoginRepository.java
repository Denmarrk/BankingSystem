package com.example.demo.Repository;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.domain.UserLogin;


@Repository
public interface LoginRepository extends JpaRepository<UserLogin, Long>{
	UserLogin findByUsernameAndPassword (String username,String password);

	
	UserLogin findByAccountnumber(String accountnumber);


	List<UserLogin> findByContactnumberAndFirstnameAndLastname(String contactnumber, String firstname,
			String lastname);

	


}
