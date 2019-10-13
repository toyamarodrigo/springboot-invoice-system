package com.rt.springboot.app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rt.springboot.app.models.entity.Client;
import com.rt.springboot.app.models.service.IClientService;
import com.rt.springboot.app.util.paginator.PageRender;

@Controller
@SessionAttributes("client")
public class ClientController {

	@Autowired
	private IClientService clientService;
	
	/* ----- List Clients -----*/
	@GetMapping(value = "/list")
	public String list(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		
		Pageable pageRequest = PageRequest.of(page, 5);
		Page<Client> clients = clientService.findAll(pageRequest);
		PageRender<Client> pageRender = new PageRender<>("/list", clients);
		
		model.addAttribute("title", "Clients List");
		model.addAttribute("clients", clients);
		model.addAttribute("page", pageRender);
		return "list";
	}
	
	/* ----- Create Client -----*/
	@GetMapping(value = "/form")
	public String create(Model model) {
		Client client = new Client();		
		model.addAttribute("client", client);
		model.addAttribute("title", "Client Form");
		return "form";
	}
	
	/* ----- Edit Client ----- */
	@GetMapping(value = "/form/{id}")
	public String update(@PathVariable(value = "id") Long id, RedirectAttributes flash, Model model) {
		
		Client client = null;
		
		if (id > 0) {
			client = clientService.findOne(id);
			if (client == null) {
				flash.addFlashAttribute("error", "The Client ID does not exist in the DB");
				return "redirect:/list";
			}
		} else {
			flash.addFlashAttribute("error", "The Client ID can not be zero");
			return "redirect:/list";
		}
		
		model.addAttribute("client", client);
		model.addAttribute("title", "Edit Client");
		
		return "form";
	}
	
	/* ----- Save Client ----- */
	@PostMapping(value = "/form")
	public String save(@Valid Client client, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("title", "Client Form");
			return "form";
		}
		
		String flashMsg = (client.getId() != null) ? "Client updated" : "Client created";
		
		clientService.save(client);
		status.setComplete();
		flash.addFlashAttribute("sucess", flashMsg);
		return "redirect:/list";
	}
	
	/* ----- Delete Client ----- */
	@GetMapping(value = "/delete/{id}")
	public String delete(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		if(id > 0) {
			clientService.delete(id);
		}
		flash.addFlashAttribute("sucess", "Client deleted");
		return "redirect:/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
