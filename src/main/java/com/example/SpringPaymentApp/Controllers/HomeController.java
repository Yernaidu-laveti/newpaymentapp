package com.example.SpringPaymentApp.Controllers;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringPaymentApp.User;
import com.example.SpringPaymentApp.entity.BankAccounts;
import com.example.SpringPaymentApp.services.BankService;
import com.example.SpringPaymentApp.services.UserService;

import jakarta.servlet.http.HttpSession;



@Controller
public class HomeController {
	
	@Autowired
	UserService serv;
	
	@Autowired
	BankService bankserv;

//    @GetMapping("/index")
//    public String homePage() {
//        return "index";  // Renders home.jsp
//    }

    @GetMapping("/updatedata")
    public String update(Model model,@RequestParam("Username") String Username,@RequestParam("lastname") String lastname,@RequestParam("firstname") String firstname,
    		@RequestParam("email") String email,@RequestParam("dob") String dob,@RequestParam("address") String address,@RequestParam("phno") int phno,HttpSession session)
    {
    	int id=(int)session.getAttribute("profileid");
    	int updated=serv.update(id,Username,firstname,lastname,email,phno,dob,address);
    	
    	User user=serv.getProfile(id);
    	model.addAttribute("userName",user.getUserName());
    	model.addAttribute("firstName",user.getFirstName());
    	model.addAttribute("lastName",user.getLastName());
    	model.addAttribute("email",user.getEmail());
    	model.addAttribute("phoneNum",user.getPhoneNum());
    	model.addAttribute("dob",user.getDob());
    	model.addAttribute("address",user.getAddress());
    	if(updated>0)
    	{
    		model.addAttribute("msg","Updated successfully");
    		return "profile";
    	}
    	else
    	{
    		model.addAttribute("msg","Updated unsuccessfully");
    		return "profile";
    	}
    	
    }
    @GetMapping("/profile")
    public String profilePage(Model model,HttpSession session) {
    	int id=(int)session.getAttribute("profileid");
    	User user=serv.getProfile(id);
    	model.addAttribute("userName",user.getUserName());
    	model.addAttribute("firstName",user.getFirstName());
    	model.addAttribute("lastName",user.getLastName());
    	model.addAttribute("email",user.getEmail());
    	model.addAttribute("phoneNum",user.getPhoneNum());
    	model.addAttribute("dob",user.getDob());
    	model.addAttribute("address",user.getAddress());
//    	BankAccounts accounts=null;
//    	accounts=bankserv.getAccounts(8235088);
//    	model.addAttribute("accounts",accounts);
        return "profile";  // Renders profile.jsp
    }
    
    @GetMapping("/profiledelete")
    public String profileDelete(HttpSession session,Model model)
    {
    	int id=(int)session.getAttribute("profileid");
    	int delete=serv.deleteProfile(id);
    	model.addAttribute("msg","Profile Deleted Successfully");
    	session.invalidate();
    	return "login";
    }

//    @GetMapping("/transactions")
//    public String transactionsPage() {
//        return "transactions";  // Renders transactions.jsp
//    }

    @GetMapping("/bankStatement")
    public String statementPage() {
        return "bankStatement";  // Renders statement.jsp
    }

  

    @GetMapping("/addmoney")
    public String addMoney(HttpSession session,Model model) {
    	
    	int id=(int)session.getAttribute("profileid");
		ArrayList<BankAccounts> accounts=new ArrayList<BankAccounts>();
		accounts=bankserv.getAccounts(id);
		model.addAttribute("bankaccounts",accounts);
        return "addmoney";  // Renders logout.jsp
    }
    
  
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	
    	session.invalidate();
        return "login";  // Renders logout.jsp
    }
    
    
  
    
   
}