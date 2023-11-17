package com.demo.services;

import java.util.List;

import com.demo.entity.TicketBooking;

public interface TicketBookingService {
	TicketBooking saveTicketBooking(TicketBooking ticketBooking);
    TicketBooking getTicketBookingById(Long id);
    TicketBooking updateTicketBooking(TicketBooking ticketBooking);
    void deleteTicketBooking(Long id);
    List<TicketBooking> filterByDate(String filterDate);
}
