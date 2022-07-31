package com.example.demo.Service;



public class SaveData {

	private String username;

	private String password;
	
	private String firstname;

	private int Id; 

	private String accountnumber; 

	private String contactnumber;

	private String lastname;
	
	private double totalbalance;

	private String creationdate;

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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

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

	public String getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}

	public SaveData(String username, String password, String firstname, int id, String accountnumber,
			String contactnumber, String lastname, double totalbalance, String creationdate) {
		super();
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		Id = id;
		this.accountnumber = accountnumber;
		this.contactnumber = contactnumber;
		this.lastname = lastname;
		this.totalbalance = totalbalance;
		this.creationdate = creationdate;
	}

	public SaveData() {

	}
	
	
	
	
	
	

}
