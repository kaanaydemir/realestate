package com.people.realestate.dtos.restdtos.createlocationpoint;

import com.people.realestate.dtos.base.BaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
    public class CreateLocationPointRequest extends BaseRequest {

    @NotBlank(message = "Name is required")
    private final String name;
    private final Long upperId;

    @NotNull(message = "Location type is required")
    private final Integer locationType;

}
