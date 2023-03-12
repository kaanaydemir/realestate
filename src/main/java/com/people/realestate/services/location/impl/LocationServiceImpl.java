package com.people.realestate.services.location.impl;

import com.people.realestate.exception.LocationNotFoundException;
import com.people.realestate.model.LocationPoint;
import com.people.realestate.repository.LocationPointRepository;
import com.people.realestate.services.location.LocationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationPointRepository locationPointRepository;

    public LocationServiceImpl(LocationPointRepository locationPointRepository) {
        this.locationPointRepository = locationPointRepository;
    }

    @Override
    public LocationPoint create(LocationPoint locationPoint) {
        return locationPointRepository.save(locationPoint);
    }

    @Override
    public LocationPoint update(LocationPoint locationPoint) {
        return locationPointRepository.save(locationPoint);
    }

    @Override
    public void delete(Long id) {
        locationPointRepository.deleteById(id);
    }

    @Override
    public List<LocationPoint> getAll() {
        return locationPointRepository.findAll();
    }

    @Override
    public LocationPoint findById(Long id) {
        return locationPointRepository.findById(id).orElseThrow(LocationNotFoundException::new);
    }
}
