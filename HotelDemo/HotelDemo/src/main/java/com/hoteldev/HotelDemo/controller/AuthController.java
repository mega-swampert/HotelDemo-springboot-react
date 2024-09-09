package com.hoteldev.HotelDemo.controller;

import com.hoteldev.HotelDemo.dto.LoginRequest;
import com.hoteldev.HotelDemo.dto.Response;
import com.hoteldev.HotelDemo.entity.User;
import com.hoteldev.HotelDemo.service.interfac.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: AuthController
 * Package: com.hoteldev.HotelDemo.controller
 * Description:
 *
 * @Author MegaSwampert
 * @Create 6/09/2024 3:42 pm
 * @Version 1.0
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody User user){
        Response response = userService.register(user);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody LoginRequest loginRequest){
        Response response = userService.login(loginRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
}
