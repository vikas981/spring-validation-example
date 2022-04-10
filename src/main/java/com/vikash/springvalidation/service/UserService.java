package com.vikash.springvalidation.service;

import com.vikash.springvalidation.web.model.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto findUserById(Long userId);
}
