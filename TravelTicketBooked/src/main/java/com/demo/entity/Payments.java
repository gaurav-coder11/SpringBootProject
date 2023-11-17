package com.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String payerName;
    
    @NotNull
    private String travelName;

    @NotNull
    private BigDecimal paymentAmount;

    @NotNull
    private LocalDate paymentDate;

    private String paymentDescription;

//    @OneToOne
//    @JoinColumn(name = "ticket_booking_id")
//    private TicketBooking ticketBooking;
}