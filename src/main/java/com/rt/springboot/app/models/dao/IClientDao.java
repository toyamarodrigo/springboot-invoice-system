package com.rt.springboot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.rt.springboot.app.models.entity.Client;

public interface IClientDao extends PagingAndSortingRepository<Client, Long>{

}
