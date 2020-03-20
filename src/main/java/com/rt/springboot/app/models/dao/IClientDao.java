package com.rt.springboot.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.rt.springboot.app.models.entity.Client;

public interface IClientDao extends PagingAndSortingRepository<Client, Long>{

	// c = Client
	// i = invoices
	@Query("select c from Client c left join fetch c.invoices i where c.id = ?1")
	public Client fetchByIdWithInvoices(Long id);
	
}
