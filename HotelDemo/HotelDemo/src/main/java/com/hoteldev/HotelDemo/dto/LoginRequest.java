package com.hoteldev.HotelDemo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * ClassName: LoginRequest
 * Package: com.hoteldev.HotelDemo.dto
 * Description:
 *
 * @Author MegaSwampert
 * @Create 5/09/2024 1:06 pm
 * @Version 1.0
 */

@Data
public class LoginRequest {

    @NotBlank(message = "email is required")
    private String email;
    @NotBlank(message = "password is required")
    private String password;

}
