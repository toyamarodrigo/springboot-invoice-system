package com.rt.springboot.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* Translation */
@Controller
public class LocaleController {

	@GetMapping("/locale")
	public String locale(HttpServletRequest request) {
		String lastUrl  = request.getHeader("referer");
		
		return "redirect:".concat(lastUrl);
	}
	
}
