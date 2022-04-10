package com.vikash.springvalidation.service;

import com.vikash.springvalidation.domain.User;
import com.vikash.springvalidation.exception.UserNotFoundException;
import com.vikash.springvalidation.repository.UserRepository;
import com.vikash.springvalidation.web.mapper.UserMapper;
import com.vikash.springvalidation.web.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user=userMapper.userDtoToUser(userDto);
        userRepository.save(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream().map(userMapper::userToUserDto)
                 .collect(Collectors.toList());
    }

    @Override
    public UserDto findUserById(Long userId) {
        return userRepository.findById(userId)
                .map(userMapper::userToUserDto)
                .orElseThrow(() -> new UserNotFoundException("User with id: "+userId+" not exists"));
    }
}
