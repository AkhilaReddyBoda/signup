package com.springboot.thyem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.thyem.model.User;
import com.springboot.thyem.service.UserService;

@Controller
public class UserController {

	@Autowired
	public UserService userService;
	
	@GetMapping
	public String viewPage() {
		return "main_page";
	}


	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());

		return "sign_up";
	}

	@PostMapping("/process")
	public String signup(User user,Model model) {
		//model.addAttribute("User",user);
		userService.AddUser(user);
		return "success_page";
	}

}
