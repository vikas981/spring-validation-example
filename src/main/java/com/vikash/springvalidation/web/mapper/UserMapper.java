package com.vikash.springvalidation.web.mapper;

import com.vikash.springvalidation.domain.User;
import com.vikash.springvalidation.web.model.UserDto;

public interface UserMapper {
    User userDtoToUser(UserDto userDto);
    UserDto userToUserDto(User user);
}
