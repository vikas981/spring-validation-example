package com.vikash.springvalidation.web.controller;

import com.vikash.springvalidation.service.UserService;
import com.vikash.springvalidation.web.model.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody @Valid UserDto userDto){
       userService.saveUser(userDto);
       return new ResponseEntity("user created successfully!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
      return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Long userId){
        return new ResponseEntity<>(userService.findUserById(userId),HttpStatus.OK);
    }

}
