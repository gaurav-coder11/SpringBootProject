package com.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filterDate;

    @NotBlank(message = "Travel name is required")
    private String travelName;

    @NotBlank(message = "To-Destination is required")
    private String toDestination;

    @NotBlank(message = "From-Destination is required")
    private String fromDestination;

    @NotNull(message = "Date and time is required")
    private LocalDateTime dateTime;

    @NotNull(message = "Price Empty")
    private Double price;
	
	

//    @OneToMany(mappedBy = "travel")
//    private List<TicketBooking> ticketBookings;
}