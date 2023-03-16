package com.people.realestate.dtos.restdtos.user.createuser;

import com.people.realestate.dtos.base.BaseRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserRequest extends BaseRequest {

    @NotBlank
    private final String firstName;

    @NotBlank
    private final String lastName;

    @Email
    private final String email;

    @NotBlank
    private final String username;
}
