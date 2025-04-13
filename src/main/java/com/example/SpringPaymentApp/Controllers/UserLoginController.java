package com.example.SpringPaymentApp.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringPaymentApp.services.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {
	
	@Autowired
	UserService service;

	@PostMapping("/login")
    public String home(@RequestParam String userName,@RequestParam String password,Model model,HttpSession session){
		
		boolean result=service.login(userName, password);
		
		if(result==true)
		{
			int id=service.getid(userName,password);
			session.setAttribute("profileid",id);
			return "index";
		}
		else
		{
			model.addAttribute("error","Details Not found");
			return "login";
		}
        
    }
    @GetMapping("/login")
    public String loginRedirect() {
        return "login"; 
    }

}


