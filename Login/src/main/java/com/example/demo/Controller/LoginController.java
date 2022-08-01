package com.example.demo.Controller;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Repository.transRepo;
import com.example.demo.Service.LoginService;
import com.example.demo.Service.SaveData;
import com.example.demo.Service.TransService;

import java.util.List;
import com.example.demo.Service.savetransact;
import com.example.demo.Transac.Transact;
import com.example.demo.Transac.Transactjson;
import com.example.demo.domain.AdminLogin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController 
{
	AdminLogin amount = new AdminLogin();
	@Autowired 
	private LoginService loginService;
	
	@Autowired 
	private TransService transService;
	
	RestTemplate restTemplate = new RestTemplate();
	SaveData save = new SaveData();
	savetransact data = new savetransact();
	AdminLogin result = new AdminLogin();
	Transact trans = new Transact();
	Transactjson translist= new Transactjson();



	@GetMapping("/login")
	public  ModelAndView loginhomepage(){
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("user",new AdminLogin() );
		return mav;
	}
	
		
	@GetMapping("/WrongPassword")
	public String WrongCredential() {
		return "WrongPassword";
		
	}
	@GetMapping("/Index")
	public String Index(Model model) {
		//result = restTemplate.getForObject("http://localhost:8080/Account/user5/"+save.getUsername(), AdminLogin.class);
		if(Objects.nonNull(result.getFirstname()))
		{
		 model.addAttribute("firstname",result.getFirstname());
		 model.addAttribute("lastname",result.getLastname());
		 model.addAttribute("accountnumber",result.getAccountnumber());
		 model.addAttribute("contactnumber",result.getContactnumber());
		 model.addAttribute("totalbalance",result.getTotalbalance());
		 model.addAttribute("creationdate",result.getCreationdate());
		return "Index";
		}
		
		else {
			
			return"redirect:/login";	
		}
		
	}
	
	@GetMapping("/")
	public String Indexs(Model model) {
		//result = restTemplate.getForObject("http://localhost:8080/Account/user5/"+save.getUsername(), AdminLogin.class);
		if(Objects.nonNull(result.getFirstname())) {
		 model.addAttribute("firstname",result.getFirstname());
		 model.addAttribute("lastname",result.getLastname());
		 model.addAttribute("accountnumber",result.getAccountnumber());
		 model.addAttribute("contactnumber",result.getContactnumber());
		 model.addAttribute("totalbalance",result.getTotalbalance());
		 model.addAttribute("creationdate",result.getCreationdate());
		return "Index";
		}
		
		else {
			
			return"redirect:/login";	
		}
		
	}
	
	//@GetMapping("/Index")
	//public  ModelAndView Index(){
	//	ModelAndView mavs = new ModelAndView("Index");
		//mavs.addObject("user",new AdminLogin() );
		//return mavs;
	//}
	
	//@RequestMapping(value = "/Index")
   // public ModelAndView home() {
    //    List<Transact> Transact = transService.getTransact(save.getAccountnumber());
   //     ModelAndView mav = new ModelAndView("Index");
    //    mav.addObject("listUserAccount", Transact);
    //    return mav;
	//}
	@RequestMapping(value = "/ListofTransaction")
   public String getTrans (Model model){
		if(Objects.nonNull(result.getFirstname())) {
       List<Transact> Transact = transService.getTransact(save.getAccountnumber());
      model.addAttribute("listUserAccount", Transact);
        
        return "ListofTransaction";
		}
		return "redirect:/login";
	}
	
	
	
	
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") AdminLogin user,Model model) throws FileNotFoundException, IOException, ParseException     {
		
		AdminLogin verifys = loginService.loginrepo(user.getUsername(), user.getPassword());
		
		if(Objects.nonNull(verifys))
		{
	   result = restTemplate.getForObject("http://localhost:8080/Account/user5/"+verifys.getUsername(), AdminLogin.class);
	   
	 //  List<Transact>  trans   = (List<Transact>) restTemplate.getForObject("http://localhost:8083/transact/user1/"+verifys.getAccountnumber(), Transact.class);
	 
	 //////////////json/////////////

	   
	   
	   
	   
	   
	// JSONObject jsnobject = new JSONObject(result1);  
	// JSONArray jsonArray = jsnobject.getJSONArray(result1);  
	
	 model.addAttribute("firstname",result.getFirstname());
	 model.addAttribute("lastname",result.getLastname());
	 model.addAttribute("username",result.getUsername());
	 model.addAttribute("accountnumber",result.getAccountnumber());
	 model.addAttribute("contactnumber",result.getContactnumber());
	 model.addAttribute("totalbalance",result.getTotalbalance());
	 model.addAttribute("creationdate",result.getCreationdate());
	 
	// model.addAttribute("listUserAccount",trans);
	// model.addAttribute("fromaccountnumber",result1.getFromaccountnumber());
	// model.addAttribute("amounttransfer",result1.getAmounttransfer());
	// model.addAttribute("toaccountnumber",result1.getToaccountnumber());
	// model.addAttribute("transactiondate",result1.getTransactiondate());
	// ArrayList<Object> listdata = new ArrayList<Object>();  
	// if (jsonArray != null) {   
	///=	 for (int i=0;i<jsonArray.length();i++){   
	     //     listdata.add(jsonArray.get(i));  
	//	 }
//	 }
	//  for(int i=0; i<listdata.size(); i++) {  
		
	save.setFirstname(result.getFirstname());
	save.setLastname(result.getLastname());
	save.setUsername(result.getUsername());
	save.setAccountnumber(result.getAccountnumber());
	save.setContactnumber(result.getContactnumber());
	save.setTotalbalance(result.getTotalbalance());
	save.setCreationdate(result.getCreationdate());
//	data.setData(translist);
	
		return "index";
	
		}else			
			
		 {
			
			model.addAttribute("error", "Wrong Password");
			
			return "login";
	   	}	
		
	}	
	
	
	  @GetMapping("/transact") 
	  public ModelAndView transactionPage()
	  {
		  if(Objects.nonNull(result.getFirstname())) {
	  ModelAndView mav = new ModelAndView("transact");
	  mav.addObject("trans",new Transact() ); 
	  return mav;
		  }else {
		  ModelAndView mav = new ModelAndView("redirect:/login");
		  //mav.addObject("user",new AdminLogin() );
		  return mav;
		  }
		  
	  }
	 
	

	
	
	@PostMapping("/transact")
	public String logins(@ModelAttribute("trans") Transact trans, Model model)     {
	
		 
			 LocalDateTime lt = LocalDateTime.now();
			 DateTimeFormatter formatters = DateTimeFormatter.ISO_DATE_TIME;
			 String s = lt.format(formatters);
			 
			 
      	  Transact result1= new Transact();	//restTemplate.postForObject("http://localhost:8083/transact/addtransact", HttpMethod.POST, Transact.class);
			  result1.setAmounttransfer(trans.getAmounttransfer());
			  result1.setFromaccountnumber(save.getAccountnumber());
		  result1.setToaccountnumber(trans.getToaccountnumber());
		  result1.setTransactiondate(s);
		  HttpHeaders headers = new HttpHeaders();
		     headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		     HttpEntity<Transact> entity = new HttpEntity<Transact>(result1,headers);
		     
		    restTemplate.exchange(
		        "http://localhost:8083/transact/addtransact", HttpMethod.POST, entity, String.class).getBody();
			
			double bal =result.getTotalbalance();
			
			  double  transfer = trans.getAmounttransfer();
			 //System.out.print(bal);
			 if (bal>=transfer) { 
				 
				 double total = bal - transfer;
		
		     model.addAttribute("firstname",save.getFirstname());
			 model.addAttribute("lastname",save.getLastname());
			 model.addAttribute("username",save.getUsername());
			 model.addAttribute("accountnumber",save.getAccountnumber());
			 model.addAttribute("contactnumber",save.getContactnumber());
			// model.addAttribute("totalbalance",save.getTotalbalance());
			 model.addAttribute("creationdate",save.getCreationdate());
			 model.addAttribute("fromaccountnumber",data.getData());
			 
			 AdminLogin up= new AdminLogin();
			 
			 up.setTotalbalance(total);
			 up.setAccountnumber(save.getAccountnumber());
			/////////////minus//////////////////////// 
		      HttpHeaders header = new HttpHeaders();
		      header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity<AdminLogin> entitys = new HttpEntity<AdminLogin>(up,header);
		      
		       restTemplate.exchange(
		         "http://localhost:8080/Account/update", HttpMethod.PUT, entitys, String.class).getBody();
		       
		       
		       
		       String result3 = restTemplate.getForObject("http://localhost:8083/transact/user1/"+save.getAccountnumber(), String.class);
		       
		       model.addAttribute("totalbalance",up.getTotalbalance());
		       model.addAttribute("fromaccountnumber",result3);
		       
		       result.setTotalbalance(up.getTotalbalance());
		   //////////////////////////////////////////////////////////    
		       
		       
		       
		       //////////////////////////// Add Money/////////////////////
		       
		       AdminLogin account = loginService.getaccount(trans.getToaccountnumber());
		   	if(Objects.nonNull(account)) {
				 AdminLogin add= new AdminLogin(); 
				 
				 
				 double addbal = account.getTotalbalance() + transfer;
				 
				 add.setAccountnumber(trans.getToaccountnumber());
				 add.setTotalbalance(addbal); HttpHeaders header1 = new HttpHeaders();
				 header1.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				 HttpEntity<AdminLogin> entitys1 = new HttpEntity<AdminLogin>(add,header1);
				 
				restTemplate.exchange( "http://localhost:8080/Account/update",
				  HttpMethod.PUT, entitys1, String.class).getBody();
				
				return "Index";
		   	}
			 //////////////////////////////////////////////////////////////////////////
		return "Index";
		
		
		
		
		
		
		
			  
			   
		 }
				model.addAttribute("error", "Not Enough Balance");
			 
			return "transact";
			
			
		
		
	}
	
	

		
		
	  //Transact result = restTemplate.getForObject("http://localhost:8084/transact/addtransact", Transact.class);
	// model.addAttribute("firstname",result.getFirstname());
	// model.addAttribute("lastname",result.getLastname());
	// model.addAttribute("username",result.getUsername());
	// model.addAttribute("accountnumber",result.getAccountnumber());
	// model.addAttribute("contactnumber",result.getContactnumber());
	// model.addAttribute("totalbalance",result.getTotalbalance());
	// model.addAttribute("creationdate",result.getCreationdate());
	  

		
		
		
	
	
}
