package com.rt.springboot.app.controllers;

import java.security.Principal;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rt.springboot.app.models.entity.User;
import com.rt.springboot.app.models.service.IUserService;

@Controller
@SessionAttributes("user")
public class UserRegistrationController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping("/signup")
	public String showRegistrationForm(Model model, Locale locale) {
		User user = new User();
		model.addAttribute("user", user);
		return "signup";
	}

	@PostMapping("/signup")
	public String registerUserAccount(
			@ModelAttribute("user") @Valid User user, 
			BindingResult result, Model model, Locale locale, 
			RedirectAttributes flash, Principal principal, Errors errors) {
		
		// Checks if User already exist
		if (userService.findByUsername(user.getUsername()) != null ) {
            model.addAttribute("warning", messageSource.getMessage("text.signup.existe", null, locale));
            System.out.println("usuario existe");
            return "signup";
        }
		
		String flashMsg = "";
		
		if(user.getUsername() != null) { 
			 flashMsg = messageSource.getMessage("text.signup.flash.crear.success", null, locale);
		}
		
		userService.save(user);
		flash.addFlashAttribute("success", flashMsg);
        return "redirect:/login";
	}

}
