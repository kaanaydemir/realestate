package com.people.realestate.controller;

import com.people.realestate.dtos.LocationPointDto;
import com.people.realestate.dtos.restdtos.createlocationpoint.CreateLocationPointRequest;
import com.people.realestate.dtos.restdtos.createlocationpoint.CreateLocationPointResponse;
import com.people.realestate.dtos.restdtos.getlocationpoints.GetLocationPointsResponse;
import com.people.realestate.mapper.LocationPointMapper;
import com.people.realestate.model.LocationPoint;
import com.people.realestate.services.location.LocationPointService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/location")
public class LocationPointController {
    private final LocationPointService locationPointService;
    private final LocationPointMapper locationPointMapper;

    public LocationPointController(LocationPointService locationPointService, LocationPointMapper locationPointMapper) {
        this.locationPointService = locationPointService;
        this.locationPointMapper = locationPointMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateLocationPointResponse> createLocationPoint(@RequestBody @Valid CreateLocationPointRequest request) {
        CreateLocationPointResponse response = locationPointService.saveLocationPoint(request);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<LocationPointDto> getLocationPoint(@PathVariable Long id) {
        LocationPoint locationPoint = locationPointService.getLocationPoint(id);

        return ResponseEntity.ok(locationPointMapper.convert(locationPoint));
    }

    @GetMapping("/get/list")
    public ResponseEntity<GetLocationPointsResponse> getLocationPointList() {
        return ResponseEntity.ok(locationPointService.getAllLocationPoints());
    }

}
