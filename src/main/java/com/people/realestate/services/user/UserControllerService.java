package com.people.realestate.services.user;


import com.people.realestate.dtos.UserDto;
import com.people.realestate.dtos.base.ResponseHeader;
import com.people.realestate.dtos.restdtos.user.createuser.CreateUserRequest;
import com.people.realestate.dtos.restdtos.user.getuser.GetUserResponse;
import com.people.realestate.mapper.UserMapper;
import com.people.realestate.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserControllerService {
    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    public UserControllerService(UserServiceImpl userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    public Long createUser(CreateUserRequest user) {
        User entity = User.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .username(user.getUsername())
                .build();

        return userService.create(entity)
                .getId();
    }

    public GetUserResponse getUser(Long id) {
        UserDto userDto = userMapper.userToUserDto(userService.findById(id));

        return GetUserResponse.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .username(userDto.getUsername())
                .createdDate(userDto.getCreatedDate())
                .modifiedDate(userDto.getModifiedDate())
                .createdBy(userDto.getCreatedBy())
                .modifiedBy(userDto.getModifiedBy())
                .isActive(userDto.getIsActive())
                .isDeleted(userDto.getIsDeleted())
                .header(new ResponseHeader())
                .build();

    }
}
