package com.hoteldev.HotelDemo.repo;

import com.hoteldev.HotelDemo.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

/**
 * ClassName: BookingRepository
 * Package: com.hoteldev.HotelDemo.repo
 * Description:
 *
 * @Author MegaSwampert
 * @Create 5/09/2024 1:20 pm
 * @Version 1.0
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<Booking> findByBookingConfirmationCode(String confirmCode);

}
