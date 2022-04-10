package com.vikash.springvalidation.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Integer age;
    private String gender;
}
