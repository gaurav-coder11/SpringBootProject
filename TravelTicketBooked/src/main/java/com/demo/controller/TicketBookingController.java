package com.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.TicketBooking;
import com.demo.services.TicketBookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ticketBookings")
public class TicketBookingController {
    private final TicketBookingService ticketBookingService;

    public TicketBookingController(TicketBookingService ticketBookingService) {
        this.ticketBookingService = ticketBookingService;
    }

    @PostMapping("/save")
    public ResponseEntity<TicketBooking> saveTicketBooking(@Valid @RequestBody TicketBooking ticketBooking, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        TicketBooking savedTicketBooking = ticketBookingService.saveTicketBooking(ticketBooking);
        return ResponseEntity.ok(savedTicketBooking);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketBooking> getTicketBooking(@PathVariable Long id) {
        TicketBooking ticketBooking = ticketBookingService.getTicketBookingById(id);
        if (ticketBooking != null) {
            return ResponseEntity.ok(ticketBooking);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<TicketBooking> updateTicketBooking(@Valid @RequestBody TicketBooking ticketBooking, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        TicketBooking updatedTicketBooking = ticketBookingService.updateTicketBooking(ticketBooking);
        return ResponseEntity.ok(updatedTicketBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicketBooking(@PathVariable Long id) {
        ticketBookingService.deleteTicketBooking(id);
        return ResponseEntity.noContent().build();
    }
    
//    @PostMapping("/filterByDate")
//    public ResponseEntity<List<TicketBooking>> filterTicketBookingsByDate(@RequestParam String filterDate) {
//        List<TicketBooking> filteredBookings = ticketBookingService.filterByDate(filterDate);
//
//        if (filteredBookings.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.ok(filteredBookings);
//        }
//    }
    
    @GetMapping("/filterByDate")
    public ResponseEntity<List<TicketBooking>> filterTicketBookingsByDate(@RequestParam String filterDate) {
        List<TicketBooking> filteredBookings = ticketBookingService.filterByDate(filterDate);

        if (filteredBookings.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(filteredBookings);
        }
    }
}

