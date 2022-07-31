package com.example.demo.Transac;


import com.fasterxml.jackson.annotation.*;
import java.util.Date;
import java.util.List;

public class Transactjson {
    private long id;
    private String fromaccountnumber;
    private long amounttransfer;
    private Date transactiondate;
    private String toaccountnumber;

    @JsonProperty("id")
    public long getId() { return id; }
    @JsonProperty("id")
    public void setId(long value) { this.id = value; }

    @JsonProperty("fromaccountnumber")
    public String getFromaccountnumber() { return fromaccountnumber; }
    @JsonProperty("fromaccountnumber")
    public void setFromaccountnumber(String value) { this.fromaccountnumber = value; }

    @JsonProperty("amounttransfer")
    public long getAmounttransfer() { return amounttransfer; }
    @JsonProperty("amounttransfer")
    public void setAmounttransfer(long value) { this.amounttransfer = value; }

    @JsonProperty("transactiondate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssX", timezone = "UTC")
    public Date getTransactiondate() { return transactiondate; }
    @JsonProperty("transactiondate")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssX", timezone = "UTC")
    public void setTransactiondate(Date value) { this.transactiondate = value; }

    @JsonProperty("toaccountnumber")
    public String getToaccountnumber() { return toaccountnumber; }
    @JsonProperty("toaccountnumber")
    public void setToaccountnumber(String value) { this.toaccountnumber = value; }
    
    
	public Transactjson() {


	}

    
 
	
		
	
    
    
    
    
    
}
