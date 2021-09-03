package com.ntpoc.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class UserRequest {

    private String address;
    private Long phoneNumber;
    private String email;
}
