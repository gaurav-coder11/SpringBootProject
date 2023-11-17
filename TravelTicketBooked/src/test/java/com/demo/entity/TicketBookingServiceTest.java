package com.demo.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.repository.TicketBookingRepository;
import com.demo.services.TicketBookingServiceImpl;

@ExtendWith(MockitoExtension.class)
class TicketBookingServiceTest {

    @Mock
    private TicketBookingRepository ticketBookingRepository;

    @InjectMocks
    private TicketBookingServiceImpl ticketBookingService;

    @Test
    void saveTicketBooking_Success() {
        // Arrange
        TicketBooking ticketBookingToSave = new TicketBooking();
        ticketBookingToSave.setId(1L);
        ticketBookingToSave.setTravelName("Test Travel");
        ticketBookingToSave.setFilterDate("2023-11-17");
        ticketBookingToSave.setFromLocation("Location A");
        ticketBookingToSave.setToLocation("Location B");
        ticketBookingToSave.setDateTime(LocalDateTime.now());
        ticketBookingToSave.setSeats(2);
        ticketBookingToSave.setEmail("test@example.com");

        // Mocking the behavior of the repository's save method
        when(ticketBookingRepository.save(any(TicketBooking.class))).thenReturn(ticketBookingToSave);

        // Act
        TicketBooking savedTicketBooking = ticketBookingService.saveTicketBooking(ticketBookingToSave);

        // Assert
        assertNotNull(savedTicketBooking);
        assertEquals(1L, savedTicketBooking.getId());
        assertEquals("Test Travel", savedTicketBooking.getTravelName());
        assertEquals("2023-11-17", savedTicketBooking.getFilterDate());
        assertEquals("Location A", savedTicketBooking.getFromLocation());
        assertEquals("Location B", savedTicketBooking.getToLocation());
        assertEquals(LocalDateTime.now().getDayOfYear(), savedTicketBooking.getDateTime().getDayOfYear()); // Just an example for date comparison
        assertEquals(2, savedTicketBooking.getSeats());
        assertEquals("test@example.com", savedTicketBooking.getEmail());

        // Verify that the save method of the repository was called
        verify(ticketBookingRepository, times(1)).save(any(TicketBooking.class));
    }
}
