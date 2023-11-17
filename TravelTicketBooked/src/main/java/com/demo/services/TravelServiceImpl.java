package com.demo.services;

import org.springframework.stereotype.Service;

import com.demo.entity.Travel;
import com.demo.exceptions.TravelNotFoundByIdException;
import com.demo.repository.TravelRepository;

@Service
public class TravelServiceImpl implements TravelService {
    private final TravelRepository travelRepository;

    public TravelServiceImpl(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    @Override
    public Travel saveTravel(Travel travel) {
        return travelRepository.save(travel);
    }

    @Override
    public Travel getTravelById(Long id) {
        return travelRepository.findById(id).orElseThrow(() -> 
        new TravelNotFoundByIdException(id));
    }

    @Override
    public Travel updateTravel(Travel travel) {
        Long id = travel.getId();

        if (id != null && travelRepository.existsById(id)) {
            return travelRepository.save(travel);
        } else {
            throw new TravelUpdateException(id);
        }
    }

    @Override
    public void deleteTravel(Long id) {
        travelRepository.deleteById(id);
    }
}