package com.tekarch.flight.TafUserService.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
public class User {

    private Long id;

    @NotEmpty(message = "Username cannot be empty")
    private String username;

    @Email(message = "Email should be valid")
    private String email;

    private String phone;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    // Getters and setters
}