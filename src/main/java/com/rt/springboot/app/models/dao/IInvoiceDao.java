package com.rt.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.rt.springboot.app.models.entity.Invoice;

public interface IInvoiceDao extends CrudRepository<Invoice, Long> {

}
