package com.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "Travel name is required")
    private String travelName;
    
    @Column
    @NotBlank(message = "Date are null")
    private String filterDate;
    
    @Column
    @NotBlank(message = "From location is required")
    private String fromLocation;

    @Column
    @NotBlank(message = "To location is required")
    private String toLocation;

    @Column
    @NotNull(message = "Date is required")
    private LocalDateTime dateTime;

    @Column
    @Min(value = 1, message = "Seats should be at least 1")
    private int seats;
    
    @Column
    @NotBlank(message = "User email is required")  // Ensure you have an attribute for user email
    private String email;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Payments payment;
}
    
//    @OneToOne(mappedBy = "ticketBooking",cascade = CascadeType.PERSIST)
//    @OneToOne
//    @JoinColumn(name = "ticket_booking_id") // Column that establishes the one-to-one relationship
//    private Payments payment;
//
//    @ManyToOne
//    private User user;
//
//    @ManyToOne
//    private Travel travel;
