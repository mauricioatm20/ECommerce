package com.code.ecom.dto;

import com.code.ecom.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private UserRole role;
}
