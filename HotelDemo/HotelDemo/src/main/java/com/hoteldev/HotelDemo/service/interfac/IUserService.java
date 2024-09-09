package com.hoteldev.HotelDemo.service.interfac;


import com.hoteldev.HotelDemo.dto.LoginRequest;
import com.hoteldev.HotelDemo.dto.Response;
import com.hoteldev.HotelDemo.entity.User;

/**
 * ClassName: IUserService
 * Package: com.hoteldev.HotelDemo.service.interfac
 * Description:
 *
 * @Author MegaSwampert
 * @Create 6/09/2024 11:25 am
 * @Version 1.0
 */
public interface IUserService {
    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String userId);

}
