package com.muhardin.endy.belajar.springvue.dto;

import com.muhardin.endy.belajar.springvue.entity.Role;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data 
public class UserDto {

    private String id;

    @NotNull @NotEmpty
    private String username;
    private String password;
    private Boolean active = true;
    private Role role;
}
