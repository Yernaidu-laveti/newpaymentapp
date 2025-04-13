package com.example.SpringPaymentApp.Controllers;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.SpringPaymentApp.UserRepository;
import com.example.SpringPaymentApp.User;

@Controller
public class UserRegistrationController {

	@Autowired
	UserRepository repo;
	
    @GetMapping("/register")
    public String home(){
        return "register";
    }
    
    @PostMapping("/register")
    public String register(User user){
    	int id=generateUniqueSevenDigitId();
    	
    	user.setUserId(id);
    	
    	repo.save(user);
        return "register";
    
        
    }

    private int generateUniqueSevenDigitId() {
        int id;
        do {
            id = generateSevenDigitId();
        } while (repo.existsByUserId(id));  // Make sure repo has this method
        return (int)id;
    }
    
    private int generateSevenDigitId() {
        Random random = new Random();
        int number = random.nextInt(1_000_0000); // Generates 0 to 9999999
        return number;    // Pads with leading zeros
    }


}