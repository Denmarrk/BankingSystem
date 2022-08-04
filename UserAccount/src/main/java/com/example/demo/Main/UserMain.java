package com.example.demo.Main;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "useraccount")
public class UserMain {
	
	@Id
	@GenericGenerator(name = "account_no", strategy = "com.example.demo.Main.AccountIdGenerator")
    @GeneratedValue(generator = "account_no") 
    @Column(columnDefinition = "varchar(22)")
	private String accountnumber; 
	@Column ( name = "contactnumber")
	private String contactnumber;
	
	@Column ( name = "firstname")
	private String firstname;
	
	@Column ( name = "lastname")
	private String lastname;
	
	 @CreationTimestamp
	 @Temporal(TemporalType.TIMESTAMP)
	@Column ( name = "creationdate")
	private Date creationdate;

	@Column ( name = "typeoffaccount")
	private String typeoffaccount;
	
	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}
	@Column ( name = "username")
	private String username;
	

	

	
	public String getTypeoffaccount() {
		return typeoffaccount;
	}

	public void setTypeoffaccount(String typeoffaccount) {
		this.typeoffaccount = typeoffaccount;
	}
	@Column ( name = "Totalbalance")
	private int totalbalance;



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

	public UserMain(String accountnumber, String contactnumber, String firstname, String lastname, Date creationdate,
			String typeoffaccount, String username, int totalbalance) {
		super();
		this.accountnumber = accountnumber;
		this.contactnumber = contactnumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.creationdate = creationdate;
		this.typeoffaccount = typeoffaccount;
		this.username = username;
		this.totalbalance = totalbalance;
	}

	@Override
	public String toString() {
		return "UserMain [accountnumber=" + accountnumber + ", contactnumber=" + contactnumber + ", firstname="
				+ firstname + ", lastname=" + lastname + ", creationdate=" + creationdate + ", typeoffaccount="
				+ typeoffaccount + ", username=" + username + ", totalbalance=" + totalbalance + "]";
	}

	
	
	

}
