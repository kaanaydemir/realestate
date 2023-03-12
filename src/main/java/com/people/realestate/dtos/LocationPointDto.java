package com.people.realestate.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.people.realestate.enums.LocationType;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.people.realestate.model.LocationPoint} entity
 */
@Data
public class LocationPointDto implements Serializable {
    private final Long id;
    private final String name;
    private final Long upperId;
    private final Integer locationType;

    @JsonIgnore
    private final LocalDateTime createdDate;

    @JsonIgnore
    private final LocalDateTime modifiedDate;

    @JsonIgnore
    private final String createdBy;

    @JsonIgnore
    private final String modifiedBy;

    @JsonIgnore
    private final Boolean isActive;

    @JsonIgnore
    private final Boolean isDeleted;

}