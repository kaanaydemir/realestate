package com.people.realestate.dtos.base;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class BaseResponse {
    private ResponseHeader header;
}
