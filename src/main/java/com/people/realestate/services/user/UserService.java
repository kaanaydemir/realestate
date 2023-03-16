package com.people.realestate.services.user;

import com.people.realestate.model.User;
import com.people.realestate.services.BaseService;

import java.util.Optional;

public interface UserService extends BaseService<User> {
    User findByUsername(String username);
}

