package com.example.Controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Validators.Validators;
import com.example.model.User;

@Component
public class Controller {

	@Autowired
	 private Validators validators;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(validators);
	}
    
	@GetMapping("login")
	public String userForm(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("welcome")
	public String saveUser(@ModelAttribute("user") @Validated User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "login";//Redirecting to input page
		}
		return "welcome";
	}
	}

