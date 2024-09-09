package com.hoteldev.HotelDemo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hoteldev.HotelDemo.entity.Booking;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: UserDTO
 * Package: com.hoteldev.HotelDemo.dto
 * Description:
 *
 * @Author MegaSwampert
 * @Create 5/09/2024 12:21 pm
 * @Version 1.0
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    private Long id;
    private String email;
    private String name;
    private String phoneNumber;
    private String role;
    private List<BookingDTO> bookings = new ArrayList<>();
}
