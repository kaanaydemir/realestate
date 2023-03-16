package com.people.realestate.controller;

import com.people.realestate.dtos.restdtos.user.createuser.CreateUserRequest;
import com.people.realestate.dtos.restdtos.user.getuser.GetUserResponse;
import com.people.realestate.model.User;
import com.people.realestate.services.user.UserControllerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserControllerService userControllerService;

    public UserController(UserControllerService userControllerService) {
        this.userControllerService = userControllerService;
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok()
                .body(userControllerService.createUser(request));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<GetUserResponse> getUser(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(userControllerService.getUser(id));
    }

}
