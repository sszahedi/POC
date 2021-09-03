package com.ntpoc.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    @NotBlank(message = "firstName must not be empty")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "lastName must not be empty")
    private String lastName;

    @Column(name = "address")
    @NotBlank(message = "address must not be empty")
    private String address;

    @Column(name = "phone_number")
    @NotNull(message = "phone number must not be empty")
    private Long phoneNumber;

    @Column(name = "email")
    @Email
    @NotNull(message = "email must not be empty")
    private String email;
    public User(
            String firstName,
            String lastName,
            String address,
            Long phoneNumber,
            String email
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
