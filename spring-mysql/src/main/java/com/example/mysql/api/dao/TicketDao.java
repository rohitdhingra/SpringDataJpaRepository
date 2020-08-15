package com.example.mysql.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.mysql.api.model.Ticket;

public interface TicketDao extends CrudRepository<Ticket,Integer> {

}
