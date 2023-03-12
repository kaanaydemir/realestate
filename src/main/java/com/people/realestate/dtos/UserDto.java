package com.people.realestate.dtos;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.people.realestate.model.User} entity
 */
@Data
public class UserDto implements Serializable {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String username;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;
    private final String createdBy;
    private final String modifiedBy;
    private final Boolean isActive;
    private final Boolean isDeleted;


}