package com.people.realestate.services;

import com.people.realestate.advice.LogExecutionTime;
import com.people.realestate.dtos.base.ResponseHeader;
import com.people.realestate.dtos.restdtos.createlocationpoint.CreateLocationPointRequest;
import com.people.realestate.dtos.restdtos.createlocationpoint.CreateLocationPointResponse;
import com.people.realestate.enums.LocationType;
import com.people.realestate.model.LocationPoint;
import com.people.realestate.repository.LocationPointRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationPointService {
    private final LocationPointRepository locationPointRepository;

    public LocationPointService(LocationPointRepository locationPointRepository) {
        this.locationPointRepository = locationPointRepository;
    }

    @LogExecutionTime
    public CreateLocationPointResponse saveLocationPoint(CreateLocationPointRequest request) {

        LocationPoint locationPoint = LocationPoint.builder()
                .name(request.getName())
                .upperId(request.getUpperId())
                .locationType(LocationType.fromValue(request.getLocationType()))
                .createdBy(request.getHeader().getUsername())
                .build();

        LocationPoint save = locationPointRepository.save(locationPoint);


        return CreateLocationPointResponse.builder()
                .header(new ResponseHeader())
                .id(save.getId())
                .name(save.getName())
                .upperId(save.getUpperId())
                .locationType(save.getLocationType().getValue())
                .createdDate(save.getCreatedDate())
                .modifiedDate(save.getModifiedDate())
                .createdBy(save.getCreatedBy())
                .modifiedBy(save.getModifiedBy())
                .isActive(save.getIsActive())
                .isDeleted(save.getIsDeleted())
                .build();
    }
    public LocationPoint getLocationPoint(Long id) {
        return locationPointRepository.findById(id).orElse(null);
    }
    public List<LocationPoint> getAllLocationPoints() {
        return locationPointRepository.findAll();
    }

    public void deleteLocationPoint(Long id) {
        locationPointRepository.deleteById(id);
    }
}
