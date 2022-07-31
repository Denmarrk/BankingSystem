package com.example.demo.Main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "useraccount")
public class UserMain {
	
	@Id
	
	@Column ( name = "Id")
	private int Id; 
	
	@Column ( name = "accountnumber")
	private String accountnumber; 
	
	@Column ( name = "contactnumber")
	private String contactnumber;
	
	@Column ( name = "firstname")
	private String firstname;
	
	@Column ( name = "lastname")
	private String lastname;
	

	@Column ( name = "creationdate")
	private String creationdate;

	
	
	
	public String getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}
	@Column ( name = "username")
	private String username;
	

	

	
	@Column ( name = "Totalbalance")
	private int totalbalance;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



	public String getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public int getTotalbalance() {
		return totalbalance;
	}

	public void setTotalbalance(int totalbalance) {
		this.totalbalance = totalbalance;
	}

	public UserMain() {
		
	}

	public UserMain(int id, String accountnumber, String contactnumber, String firstname, String lastname,
			String creationdate, String username, int totalbalance) {
		super();
		Id = id;
		this.accountnumber = accountnumber;
		this.contactnumber = contactnumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.creationdate = creationdate;
		this.username = username;
		this.totalbalance = totalbalance;
	}

	@Override
	public String toString() {
		return "UserMain [Id=" + Id + ", accountnumber=" + accountnumber + ", contactnumber=" + contactnumber
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", creationdate=" + creationdate
				+ ", username=" + username + ", totalbalance=" + totalbalance + "]";
	}




	
	
	

}
