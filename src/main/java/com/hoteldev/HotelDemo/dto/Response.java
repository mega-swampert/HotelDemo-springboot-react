package com.hoteldev.HotelDemo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * ClassName: Response
 * Package: com.hoteldev.HotelDemo.dto
 * Description:
 *
 * @Author MegaSwampert
 * @Create 5/09/2024 1:09 pm
 * @Version 1.0
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private int statusCode;
    private String message;

    private String token;
    private String role;
    private String expirationTime;
    private String bookingConfirmationCode;

    private UserDTO user;
    private RoomDTO room;
    private BookingDTO booking;

    private List<UserDTO> userList;
    private List<RoomDTO> roomList;
    private List<BookingDTO> bookingList;
}
