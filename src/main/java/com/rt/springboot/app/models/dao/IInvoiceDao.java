package com.rt.springboot.app.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rt.springboot.app.models.entity.Invoice;

public interface IInvoiceDao extends CrudRepository<Invoice, Long> {
	
	// i = invoice
	// c = client
	// l(L) = items
	@Query("select i from Invoice i join fetch i.client c join fetch i.items l join fetch l.product where i.id = ?1")
	public Invoice fetchByIdWithClientWithInvoiceItemWithProduct(Long id);

}
