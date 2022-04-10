package com.vikash.springvalidation.web.mapper;

import com.vikash.springvalidation.domain.User;
import com.vikash.springvalidation.web.model.Gender;
import com.vikash.springvalidation.web.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User userDtoToUser(UserDto userDto) {
        if(userDto == null){
            return null;
        }
        User user=new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        if(userDto.getGender()!=null){
            user.setGender(Enum.valueOf(Gender.class,userDto.getGender()));
        }
        user.setPhone(userDto.getPhone());
        user.setAge(userDto.getAge());
        return user;
    }

    @Override
    public UserDto userToUserDto(User user) {
        if(user == null){
            return null;
        }
        UserDto userDto=new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        if ( user.getGender() != null ) {
            userDto.setGender( user.getGender().name());
        }
        userDto.setPhone(user.getPhone());
        userDto.setAge(user.getAge());
        return userDto;
    }
}
