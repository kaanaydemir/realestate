package com.people.realestate.mapper;

import com.people.realestate.dtos.LocationPointDto;
import com.people.realestate.enums.LocationType;
import com.people.realestate.model.LocationPoint;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring")
public interface LocationPointMapper {


    @Mappings({
            @Mapping(target = "locationType",
                     expression = "java(integerToEnum(locationPointDto.getLocationType()))")
    })
    LocationPoint convert(LocationPointDto locationPointDto);

    @Mappings({
            @Mapping(target = "locationType",
                     expression = "java(enumToInteger(locationPoint.getLocationType()))")
    })
    LocationPointDto convert(LocationPoint locationPoint);

    default LocationType integerToEnum(Integer locationType) {
        return LocationType.fromValue(locationType);
    }

    default Integer enumToInteger(LocationType locationType) {
        return locationType.getValue();
    }

}
