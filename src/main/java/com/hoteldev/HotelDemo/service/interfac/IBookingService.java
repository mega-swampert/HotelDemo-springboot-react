package com.hoteldev.HotelDemo.service.interfac;

import com.hoteldev.HotelDemo.dto.Response;
import com.hoteldev.HotelDemo.entity.Booking;

/**
 * ClassName: IBookingService
 * Package: com.hoteldev.HotelDemo.service.interfac
 * Description:
 *
 * @Author MegaSwampert
 * @Create 6/09/2024 2:38 pm
 * @Version 1.0
 */
public interface IBookingService {

    Response saveBooking(Long roomId, Long userId, Booking bookingRequest);

    Response findBookingByConfirmationCode(String confirmationCode);

    Response getAllBookings();

    Response cancelBooking(Long bookingId);
}
