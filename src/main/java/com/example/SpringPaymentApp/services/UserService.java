package com.example.SpringPaymentApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringPaymentApp.User;
import com.example.SpringPaymentApp.UserRepository;


@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public boolean login(String userName,String password)
	{
		boolean found=false;
		found=userRepo.existsByUserNameAndPassword(userName,password);
		return found;
		
	}

	public User getProfile(int userId) 
	{
		User user=null;
		user=userRepo.findByUserId(userId);
		return user;
		//user=userRepo.getProfile();
	}

	public int update(int userId, String username, String firstname, String lastname, String email, int phno, String dob, String address) {
		
		return userRepo.updateByUserId(userId,username,firstname,lastname,email,phno,dob,address);
	}

	public int  getid(String userName, String password) {
		// TODO Auto-generated method stub
		 User user=userRepo.findByUserNameAndPassword(userName,password);
		 
		 return user.getUserId();
	}

	public int deleteProfile(int userId) {
		return userRepo.deleteByUserId(userId); //built in
	}

	

	

}
