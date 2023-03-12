package com.people.realestate.dtos.base;

import com.people.realestate.enums.ResponseType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
public class ResponseHeader {
    private ResponseType responseType;
    private Integer responseCode;
    private String responseMessage;
    private String responseDescription;

    public ResponseHeader() {
        responseType = ResponseType.SUCCESS;
        responseCode = 0;
        responseMessage = "Success";
        responseDescription = "Success";
    }
}
