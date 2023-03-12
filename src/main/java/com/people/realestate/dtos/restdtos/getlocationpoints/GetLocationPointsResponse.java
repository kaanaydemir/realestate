package com.people.realestate.dtos.restdtos.getlocationpoints;

import com.people.realestate.dtos.LocationPointDto;
import com.people.realestate.dtos.base.BaseRequest;
import com.people.realestate.dtos.base.BaseResponse;
import com.people.realestate.model.LocationPoint;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Data
public class GetLocationPointsResponse extends BaseResponse {
    private List<LocationPointDto> locationPoints;
}
