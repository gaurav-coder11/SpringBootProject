package com.demo.services;

import com.demo.entity.Travel;

public interface TravelService {
    Travel saveTravel(Travel travel);
    Travel getTravelById(Long id);
    Travel updateTravel(Travel travel);
    void deleteTravel(Long id);
}