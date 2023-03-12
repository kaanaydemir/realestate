package com.people.realestate.dtos.restdtos.createlocationpoint;

import com.people.realestate.dtos.base.BaseResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class CreateLocationPointResponse extends BaseResponse {
    private  Long id;
    private  String name;
    private  Long upperId;
    private  Integer locationType;
    private  LocalDateTime createdDate;
    private  LocalDateTime modifiedDate;
    private  String createdBy;
    private  String modifiedBy;
    private  Boolean isActive;
    private  Boolean isDeleted;



}
