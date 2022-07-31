package com.example.demo.Transac;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transact {
	@Id
	@GeneratedValue
    private int id;
	private String fromaccountnumber;
	private Double amounttransfer;
	private String transactiondate;
	private String toaccountnumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFromaccountnumber() {
		return fromaccountnumber;
	}
	public void setFromaccountnumber(String fromaccountnumber) {
		this.fromaccountnumber = fromaccountnumber;
	}
	public Double getAmounttransfer() {
		return amounttransfer;
	}
	public void setAmounttransfer(Double amounttransfer) {
		this.amounttransfer = amounttransfer;
	}
	public String getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}
	public String getToaccountnumber() {
		return toaccountnumber;
	}
	public void setToaccountnumber(String toaccountnumber) {
		this.toaccountnumber = toaccountnumber;
	}
	public Transact(int id, String fromaccountnumber, Double amounttransfer, String transactiondate,
			String toaccountnumber) {
		this.id = id;
		this.fromaccountnumber = fromaccountnumber;
		this.amounttransfer = amounttransfer;
		this.transactiondate = transactiondate;
		this.toaccountnumber = toaccountnumber;
	}
	public Transact() {

		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
