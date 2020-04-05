package com.rt.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rt.springboot.app.models.service.IClientService;
import com.rt.springboot.app.view.xml.ClientList;

@RestController
@RequestMapping("/api/clients")
public class ClientRestController {
	
	@Autowired
	private IClientService clientService;

	/* ----- List Client API-REST ----- */
	@GetMapping(value = "/list")
	public ClientList list() {
		
		return new ClientList(clientService.findAll());
	
	}
	
}
