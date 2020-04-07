package com.rt.springboot.app.view.json;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.rt.springboot.app.models.entity.Client;

@Component("list.json")
public class ClientListJsonView extends MappingJackson2JsonView {

	@Override
	protected Object filterModel(Map<String, Object> model) {

		model.remove("title");
		model.remove("page");
		
		@SuppressWarnings("unchecked")
		Page<Client> clients = (Page<Client>) model.get("clients");
		
		model.remove("clients");
		model.put("clients", clients.getContent());
		
		return super.filterModel(model);
	}
	
	

}
