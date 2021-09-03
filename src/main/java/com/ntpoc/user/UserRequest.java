package com.ntpoc.user;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserRequest {

    @NotBlank
    private String address;

    @NotBlank
    private Long phoneNumber;

    @NotBlank
    @Email
    private String email;
}
