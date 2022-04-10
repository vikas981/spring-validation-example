package com.vikash.springvalidation.domain;

import com.vikash.springvalidation.web.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull(message = "Firstname shouldn't be null")
    private String firstName;

    @NotNull(message = "Lastname shouldn't be null")
    private String lastName;

    @Email(message = "Invalid email address")
    private String email;

    @Pattern(regexp = "^\\d{10}$")
    private String phone;

    @Min(value = 16,message = "Not eligible")
    @Max(value = 60,message = "Not eligible")
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
