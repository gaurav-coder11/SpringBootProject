package com.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entity.TicketBooking;
import com.demo.exceptions.UserNotFoundByFilterDateException;
import com.demo.exceptions.UserNotFoundByIdException;
import com.demo.repository.TicketBookingRepository;

@Service
public class TicketBookingServiceImpl implements TicketBookingService {
    private final TicketBookingRepository ticketBookingRepository;

    public TicketBookingServiceImpl(TicketBookingRepository ticketBookingRepository) {
        this.ticketBookingRepository = ticketBookingRepository;
    }

    @Override
    public TicketBooking saveTicketBooking(TicketBooking ticketBooking) {
        return ticketBookingRepository.save(ticketBooking);
    }

    @Override
    public TicketBooking getTicketBookingById(Long id) {
        return ticketBookingRepository.findById(id).orElseThrow(() -> 
        new UserNotFoundByIdException(id));
    }

    @Override
    public TicketBooking updateTicketBooking(TicketBooking ticketBooking) {
        return ticketBookingRepository.save(ticketBooking);
    }

    @Override
    public void deleteTicketBooking(Long id) {
        ticketBookingRepository.deleteById(id);
    }

    @Override
    public List<TicketBooking> filterByDate(String filterDate) {
        List<TicketBooking> filteredBookings = ticketBookingRepository.findByFilterDate(filterDate);

        if (filteredBookings.isEmpty()) {
            throw new UserNotFoundByFilterDateException(filterDate);
        }

        return filteredBookings;
    }
}
