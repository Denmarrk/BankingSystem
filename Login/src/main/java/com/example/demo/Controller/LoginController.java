package com.example.demo.Controller;



import java.util.Arrays;
import java.util.Objects;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.Service.LoginService;
import com.example.demo.Service.TransService;


import java.util.List;
import com.example.demo.Service.savetransact;
import com.example.demo.Transac.Transact;

import com.example.demo.domain.UserLogin;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController 
{
	UserLogin amount = new UserLogin();
	@Autowired 
	private LoginService loginService;
	

	@Autowired 
	private TransService transService;
	
	RestTemplate restTemplate = new RestTemplate();

	savetransact data = new savetransact();
	UserLogin result = new UserLogin();
	Transact trans = new Transact();
	UserLogin addnew = new UserLogin(); 

	
	
	@GetMapping("/login")
	public  ModelAndView loginhomepage(){
		  if(Objects.nonNull(result.getFirstname())) 
		  {
				ModelAndView mav = new ModelAndView("redirect:/");
			//	mav.addObject("user",new UserLogin() );
				return mav;
		  }
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("user",new UserLogin() );
			return mav;
	}
	
	
	
	
	
	@GetMapping("/logout")
	public  String logout(){
		result.setFirstname(null);
		return "redirect:/login";
		
		
	}
	
	
	
	@RequestMapping("/login")
	public String login(@ModelAttribute("user") UserLogin user,Model model)    {
	
		
		System.out.print(user.getUsername());
		if (!user.getUsername().equals(null)) {
		
			
			UserLogin verifys = loginService.loginrepo(user.getUsername(), user.getPassword());
			if(Objects.nonNull(verifys))
			{
		   result = restTemplate.getForObject("http://localhost:8080/user5/"+verifys.getUsername(), UserLogin.class);
		 model.addAttribute("firstname",result.getFirstname());
		 model.addAttribute("lastname",result.getLastname());
		 model.addAttribute("username",result.getUsername());
		 model.addAttribute("accountnumber",result.getAccountnumber());
		 model.addAttribute("contactnumber",result.getContactnumber());
		 model.addAttribute("totalbalance",result.getTotalbalance());
		 model.addAttribute("creationdate",result.getCreationdate());
		 
		 ////////////////////////////////////List of Account///////////////////////////////
		 
			return "redirect:/";
			
			}else			
			 {
				model.addAttribute("error", "Wrong Password");	
				return "login";
		   	}
			
			
			
		}
		else {
			model.addAttribute("error", "Wrong Password");	
			return"login";
		}
		
	}	
	
	/*
	 * @GetMapping("/Index") public String Index(Model model) {
	 * 
	 * if(Objects.nonNull(result.getFirstname())) {
	 * 
	 * model.addAttribute("firstname",result.getFirstname());
	 * model.addAttribute("lastname",result.getLastname());
	 * model.addAttribute("accountnumber",result.getAccountnumber());
	 * model.addAttribute("contactnumber",result.getContactnumber());
	 * model.addAttribute("totalbalance",result.getTotalbalance());
	 * model.addAttribute("creationdate",result.getCreationdate()); return "Index";
	 * }
	 * 
	 * else {
	 * 
	 * return"redirect:/login"; }
	 * 
	 * }
	 */
	@GetMapping("/")
	public String Indexs(Model model) {
		
		if(Objects.nonNull(result.getFirstname())) {
			
	     List<UserLogin> Listuser = loginService.getNewList(result.getContactnumber(), result.getFirstname(), result.getLastname());
	      model.addAttribute("listUserAccount", Listuser);
	      
	     
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
	

	
	
	
	
	@GetMapping("/ListofTransaction")
   public String getTrans (Model model){
		if(Objects.nonNull(result.getFirstname()))
		{
			
       List<Transact> Transact = transService.getTransact(result.getAccountnumber());
      model.addAttribute("listUserAccount", Transact);
        
        return "ListofTransaction";
		}
		return "redirect:/login";
	}
	


	  @GetMapping("/transact") 
	  public ModelAndView transactionPage()
	  {
		  if(Objects.nonNull(result.getFirstname())) 
		  {
	  ModelAndView mav = new ModelAndView("transact");
	  mav.addObject("trans",new Transact() ); 
	  return mav;
		  }else 
		  {
		  ModelAndView mav = new ModelAndView("redirect:/login");
		  //mav.addObject("user",new AdminLogin() );
		  return mav;
		  }
	  }
	  
	///////////////////////////////////////////////////////////////////////////////////
	  
	  
	@PostMapping("/transact")
	public String logins(@ModelAttribute("trans") Transact trans, Model model)     {
      	  Transact result1= new Transact();
      	  
      	  
			  result1.setAmounttransfer(trans.getAmounttransfer());
			  result1.setFromaccountnumber(result.getAccountnumber());
		  result1.setToaccountnumber(trans.getToaccountnumber());
		 
		  HttpHeaders headers = new HttpHeaders();
		     headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		     HttpEntity<Transact> entity = new HttpEntity<Transact>(result1,headers);
		     
		    restTemplate.exchange(
		        "http://localhost:8083/transact/addtransact", HttpMethod.POST, entity, String.class).getBody();
			
			double bal =result.getTotalbalance();
			
			  double  transfer = trans.getAmounttransfer();
			 //System.out.print(bal);
			  if (transfer > 0) {
			 if (  bal>=transfer  ) { 
				 
				 double total = bal - transfer;
		
		     model.addAttribute("firstname",result.getFirstname());
			 model.addAttribute("lastname",result.getLastname());
			 model.addAttribute("username",result.getUsername());
			 model.addAttribute("accountnumber",result.getAccountnumber());
			 model.addAttribute("contactnumber",result.getContactnumber());
			// model.addAttribute("totalbalance",save.getTotalbalance());
			 model.addAttribute("creationdate",result.getCreationdate());
			 model.addAttribute("fromaccountnumber",data.getData()); 
			 UserLogin up= new UserLogin(); 
			 up.setTotalbalance(total);
			 up.setAccountnumber(result.getAccountnumber());
			/////////////minus//////////////////////// 
		      HttpHeaders header = new HttpHeaders();
		      header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		      HttpEntity<UserLogin> entitys = new HttpEntity<UserLogin>(up,header);
		      
		       restTemplate.exchange(
		         "http://localhost:8080/update", HttpMethod.PUT, entitys, String.class).getBody();
		       
		       
		       
		       String result3 = restTemplate.getForObject("http://localhost:8083/transact/user1/"+result.getAccountnumber(), String.class);
		       
		       model.addAttribute("totalbalance",up.getTotalbalance());
		       model.addAttribute("fromaccountnumber",result3);
		       
		       result.setTotalbalance(up.getTotalbalance());
		   //////////////////////////////////////////////////////////    
		       
		       
		       
		       //////////////////////////// Add Money/////////////////////


		       
		       UserLogin account = loginService.getaccount(trans.getToaccountnumber());
		       
		   	if(Objects.nonNull(account)) {
		   		
				 UserLogin add= new UserLogin(); 
				 
				 
				 double addbal = account.getTotalbalance() + transfer;
				 add.setAccountnumber(trans.getToaccountnumber());
				 add.setTotalbalance(addbal); HttpHeaders header1 = new HttpHeaders();
				 header1.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				 HttpEntity<UserLogin> entitys1 = new HttpEntity<UserLogin>(add,header1);
				 
				restTemplate.exchange( "http://localhost:8080/update",
				  HttpMethod.PUT, entitys1, String.class).getBody();
				
				return "redirect:/";
		   	}
			 //////////////////////////////////////////////////////////////////////////
		   	
		return "redirect:/";

		 }
				model.addAttribute("error", "Not Enough Balance");
			 
			return "transact";
			  }
			  
			  model.addAttribute("error", "You Cannot Transfer 0 Amount");
				 
				return "transact";
			  
			

	}	

	 @GetMapping("/addUser") 
	  public ModelAndView AddUser(Model model)
	  {
		  //if(Objects.nonNull(result.getFirstname())) 
		 // {
		 model.addAttribute("firstname", result.getFirstname());
		  model.addAttribute("lastname", result.getLastname());
		  model.addAttribute("contactnumber", result.getContactnumber());
	  ModelAndView mav = new ModelAndView("addUser");
	  mav.addObject("addUser",new UserLogin() ); 
	  return mav;
	  }
	  
		@PostMapping("/addUser")
		public String addUser(@ModelAttribute("addUser") UserLogin addUser, Model model)     {
	
			model.addAttribute("firstname", result.getFirstname());
			  model.addAttribute("lastname", result.getLastname());
			  model.addAttribute("contactnumber", result.getContactnumber());
			 addnew.setFirstname(result.getFirstname());
			 addnew.setLastname(result.getLastname());
		     addnew.setTypeoffaccount("Secondary");
	
			 addnew.setTotalbalance(addUser.getTotalbalance());
			addnew.setContactnumber(result.getContactnumber());
			if(addUser.getTotalbalance()>0) {
			  HttpHeaders headers = new HttpHeaders();
			     headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			     HttpEntity<UserLogin> entity = new HttpEntity<UserLogin>(addnew,headers);
			     
			    restTemplate.exchange(
			        "http://localhost:8080/adduser", HttpMethod.POST, entity, String.class).getBody();
			
			return "redirect:/";
			} else {
			model.addAttribute("error", "You Cannot Transfer 0 Amount");
			return "addUser";
			}
		}
		


			@GetMapping("/Index")
			public ModelAndView editCustomerForm(@RequestParam(value= "accountnumber") String accountnumber,Model model) {
			    ModelAndView mav = new ModelAndView("redirect:/");
			    System.out.print(accountnumber);
			    
			    result = restTemplate.getForObject("http://localhost:8080/user2/"+accountnumber, UserLogin.class);
			  model.addAttribute("firstname", result.getFirstname()); 
			  model.addAttribute("lastname", result.getLastname());
			     model.addAttribute("accountnumber", result.getAccountnumber());
				  model.addAttribute("contactnumber", result.getContactnumber());
				 model.addAttribute("totalbalance", result.getTotalbalance());
				  model.addAttribute("creationdate", result.getCreationdate());
			  
					/*
					 * result.setFirstname(news.getFirstname());
					 * result.setLastname(news.getLastname());
					 * result.setAccountnumber(news.getAccountnumber());
					 * result.setContactnumber(news.getContactnumber());
					 * result.setTotalbalance(news.getTotalbalance());
					 * result.setCreationdate(news.getCreationdate());
					 */
			    return mav;
			}
		
		
		
	
	
}
