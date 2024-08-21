package com.code.ecom.service.auth;

import com.code.ecom.dto.SignupRequest;
import com.code.ecom.dto.UserDto;

public interface AuthService {

    UserDto createUser(SignupRequest signupRequest);

    Boolean hasUserWithEmail(String email);
}
