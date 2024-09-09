package com.hoteldev.HotelDemo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hoteldev.HotelDemo.entity.Booking;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: RoomDTO
 * Package: com.hoteldev.HotelDemo.dto
 * Description:
 *
 * @Author MegaSwampert
 * @Create 5/09/2024 12:26 pm
 * @Version 1.0
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDTO {

    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private String roomPhotoUrl;
    private String roomDescription;
    private List<BookingDTO> bookings = new ArrayList<>();
}
