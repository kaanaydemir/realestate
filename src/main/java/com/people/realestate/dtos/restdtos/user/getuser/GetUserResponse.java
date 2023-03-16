package com.people.realestate.dtos.restdtos.user.getuser;

import com.people.realestate.dtos.base.BaseResponse;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
@Data
public class GetUserResponse extends BaseResponse {
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
