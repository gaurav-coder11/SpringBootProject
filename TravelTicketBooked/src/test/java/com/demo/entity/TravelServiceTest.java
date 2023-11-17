package com.demo.entity;

import static org.junit.jupiter.api.Assertions.*;
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

import com.demo.repository.TravelRepository;
import com.demo.services.TravelServiceImpl;

@ExtendWith(MockitoExtension.class)
class TravelServiceTest {

    @Mock
    private TravelRepository travelRepository;

    @InjectMocks
    private TravelServiceImpl travelService;

    @Test
    void saveTravel_Success() {
        // Arrange
        Travel travelToSave = new Travel();
        travelToSave.setId(1L);
        travelToSave.setTravelName("Test Travel");
        travelToSave.setToDestination("Destination A");
        travelToSave.setFromDestination("Destination B");
        travelToSave.setDateTime(LocalDateTime.now());
        travelToSave.setPrice(100.0);

        // Mocking the behavior of the repository's save method
        when(travelRepository.save(any(Travel.class))).thenReturn(travelToSave);

        // Act
        Travel savedTravel = travelService.saveTravel(travelToSave);

        // Assert
        assertNotNull(savedTravel);
        assertEquals(1L, savedTravel.getId());
        assertEquals("Test Travel", savedTravel.getTravelName());
        assertEquals("Destination A", savedTravel.getToDestination());
        assertEquals("Destination B", savedTravel.getFromDestination());
        assertEquals(LocalDateTime.now().getDayOfYear(), savedTravel.getDateTime().getDayOfYear()); // Just an example for date comparison
        assertEquals(100.0, savedTravel.getPrice());

        // Verify that the save method of the repository was called
        verify(travelRepository, times(1)).save(any(Travel.class));
    }
}