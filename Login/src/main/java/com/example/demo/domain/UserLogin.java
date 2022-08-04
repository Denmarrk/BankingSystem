package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="useraccount")
public class UserLogin {
	@Id
	@Column ( name = "accountnumber")
	private String accountnumber; 
	@Column (name = "username")
	private String username;
	@Column (name = "password")
	private String password;
	@Column (name ="firstname")
	private String firstname;
	@Column ( name = "typeoffaccount")
	private String typeoffaccount;


	@Column ( name = "contactnumber")
	private String contactnumber;
	@Column ( name = "lastname")
	private String lastname;
	@Column ( name = "Totalbalance")
	private double totalbalance;
	@Column ( name = "creationdate")
	private String creationdate;

	

	public String getTypeoffaccount() {
		return typeoffaccount;
	}

	public void setTypeoffaccount(String typeoffaccount) {
		this.typeoffaccount = typeoffaccount;
	}
	
	public String getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}


	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getTotalbalance() {
		return totalbalance;
	}

	public void setTotalbalance(double totalbalance) {
		this.totalbalance = totalbalance;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	




	public UserLogin(String accountnumber, String username, String password, String firstname, String typeoffaccount,
			String contactnumber, String lastname, double totalbalance, String creationdate) {
		super();
		this.accountnumber = accountnumber;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.typeoffaccount = typeoffaccount;
		this.contactnumber = contactnumber;
		this.lastname = lastname;
		this.totalbalance = totalbalance;
		this.creationdate = creationdate;
	}

	public UserLogin() {
	
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
