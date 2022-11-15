package com.group12.bizwiz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.group12.bizwiz.services.UserService;
import com.group12.bizwiz.models.LoginUser;
import com.group12.bizwiz.models.User;



@Controller
public class MainController {
	@Autowired
	private UserService userServ;
	
	@GetMapping("/")
	public String index(
		@ModelAttribute("newUserView") User user, 
		@ModelAttribute("newLoginView") LoginUser logU) {
	return "login.jsp";
	}
}