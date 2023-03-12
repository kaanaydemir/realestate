package com.people.realestate.services.location;

import com.people.realestate.dtos.LocationPointDto;
import com.people.realestate.dtos.base.ResponseHeader;
import com.people.realestate.dtos.restdtos.createlocationpoint.CreateLocationPointRequest;
import com.people.realestate.dtos.restdtos.createlocationpoint.CreateLocationPointResponse;
import com.people.realestate.dtos.restdtos.getlocationpoints.GetLocationPointsResponse;
import com.people.realestate.enums.LocationType;
import com.people.realestate.mapper.LocationPointMapper;
import com.people.realestate.model.LocationPoint;
import com.people.realestate.repository.LocationPointRepository;
import com.people.realestate.services.location.impl.LocationServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationPointService {
    private final LocationPointRepository locationPointRepository;

    private final LocationServiceImpl locationService;
    private final LocationPointMapper locationPointMapper;

    public LocationPointService(LocationPointRepository locationPointRepository, LocationServiceImpl locationService,
                                LocationPointMapper locationPointMapper) {
        this.locationPointRepository = locationPointRepository;
        this.locationService = locationService;
        this.locationPointMapper = locationPointMapper;
    }


    /**
     * It saves a location point to the database
     *
     * @param request The request object that is passed to the service.
     * @return CreateLocationPointResponse
     */
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

    /**
     * It returns a location point by id
     *
     * @param id The id of the location point
     * @return LocationPoint
     */
    public LocationPoint getLocationPoint(Long id) {
        return locationService.findById(id);
    }


    /**
     * It returns all location points from the database
     *
     * @return List<LocationPoint>
     */
    public GetLocationPointsResponse getAllLocationPoints() {
        return GetLocationPointsResponse.builder()
                .header(new ResponseHeader())
                .locationPoints(getAllLocationPointDtos())
                .build();

    }

    /**
     * It returns all location points from the database
     *
     * @return List<LocationPointDto>
     */
    public List<LocationPointDto> getAllLocationPointDtos() {
        return locationPointMapper.convert(locationService.getAll());
    }


    /**
     * It deletes a location point by id
     *
     * @param id The id of the location point
     */
    public void deleteLocationPoint(Long id) {
        locationPointRepository.deleteById(id);
    }
}
