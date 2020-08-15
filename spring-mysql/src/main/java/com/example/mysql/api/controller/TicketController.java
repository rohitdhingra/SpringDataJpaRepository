package com.example.mysql.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.api.dao.TicketDao;
import com.example.mysql.api.model.Ticket;

@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private TicketDao ticketDao;
	
	@PostMapping("/bookTickets")
	public String bookTicket(@RequestBody List<Ticket> tickets)
	{
		ticketDao.saveAll(tickets);
//		ticketDao.save(tickets.get(1));
		return "Tickets Booked"+tickets.size();
	}
	
	@GetMapping("/getTickets")
	public Iterable<Ticket> getTickets()
	{
			 return  ticketDao.findAll();
	}
	
}
