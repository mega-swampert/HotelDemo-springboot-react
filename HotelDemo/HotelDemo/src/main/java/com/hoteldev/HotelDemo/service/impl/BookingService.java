package com.hoteldev.HotelDemo.service.impl;

import com.hoteldev.HotelDemo.dto.BookingDTO;
import com.hoteldev.HotelDemo.dto.Response;
import com.hoteldev.HotelDemo.entity.Booking;
import com.hoteldev.HotelDemo.entity.Room;
import com.hoteldev.HotelDemo.entity.User;
import com.hoteldev.HotelDemo.exception.ProjectException;
import com.hoteldev.HotelDemo.repo.BookingRepository;
import com.hoteldev.HotelDemo.repo.RoomRepository;
import com.hoteldev.HotelDemo.repo.UserRepository;
import com.hoteldev.HotelDemo.service.interfac.IBookingService;
import com.hoteldev.HotelDemo.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: BookingService
 * Package: com.hoteldev.HotelDemo.service.impl
 * Description:
 *
 * @Author MegaSwampert
 * @Create 6/09/2024 2:41 pm
 * @Version 1.0
 */

@Service
public class BookingService implements IBookingService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Response saveBooking(Long roomId, Long userId, Booking bookingRequest) {
        Response response = new Response();

        try {
            if (bookingRequest.getCheckOutDate().isBefore(bookingRequest.getCheckInDate())) {
                throw new IllegalArgumentException("Check in date must come after check out date");
            }
            Room room = roomRepository.findById(roomId).orElseThrow(() -> new ProjectException("Room not found"));
            User user = userRepository.findById(userId).orElseThrow(() -> new ProjectException("User not found"));
            List<Booking> existingBooking = room.getBookings();
            if (!roomIsAvailable(bookingRequest, existingBooking)) {
                throw new ProjectException("Room not available for selected date range");
            }
            bookingRequest.setRoom(room);
            bookingRequest.setUser(user);
            String bookingConfirmationCode = Utils.generateRandomAlphanumeric(10);
            bookingRequest.setBookingConfirmationCode(bookingConfirmationCode);
            bookingRepository.save(bookingRequest);
            response.setStatusCode(200);
            response.setMessage("successful");
            response.setBookingConfirmationCode(bookingConfirmationCode);
        } catch (ProjectException ex) {
            response.setStatusCode(404);
            response.setMessage(ex.getMessage());
        } catch (Exception ex) {
            response.setStatusCode(500);
            response.setMessage("Error: Saving booking" + ex.getMessage());
        }
        return response;
    }

    private boolean roomIsAvailable(Booking bookingRequest, List<Booking> existingBookings) {
        return existingBookings.stream().noneMatch(existingBooking -> bookingRequest.getCheckInDate().equals(existingBooking.getCheckOutDate())
                || bookingRequest.getCheckOutDate().isBefore(existingBooking.getCheckOutDate())
                || (bookingRequest.getCheckInDate().isAfter(existingBooking.getCheckInDate())
                && bookingRequest.getCheckInDate().isBefore(existingBooking.getCheckOutDate()))
                || (bookingRequest.getCheckInDate().isBefore(existingBooking.getCheckInDate())

                && bookingRequest.getCheckOutDate().equals(existingBooking.getCheckOutDate()))
                || (bookingRequest.getCheckInDate().isBefore(existingBooking.getCheckInDate())

                && bookingRequest.getCheckOutDate().isAfter(existingBooking.getCheckOutDate()))

                || (bookingRequest.getCheckInDate().equals(existingBooking.getCheckOutDate())
                && bookingRequest.getCheckOutDate().equals(existingBooking.getCheckInDate()))

                || (bookingRequest.getCheckInDate().equals(existingBooking.getCheckOutDate())
                && bookingRequest.getCheckOutDate().equals(bookingRequest.getCheckInDate()))
        );
    }

    @Override
    public Response findBookingByConfirmationCode(String confirmationCode) {
        Response response = new Response();
        try {
            Booking booking = bookingRepository.findByBookingConfirmationCode(confirmationCode).orElseThrow(() -> new ProjectException("Booking Not Found"));
            BookingDTO bookingDTO = Utils.mapBookingEntityToBookingDTOPlusBookedRoom(booking, true);
            response.setStatusCode(200);
            response.setMessage("successful");
            response.setBooking(bookingDTO);
        } catch (ProjectException ex) {
            response.setStatusCode(404);
            response.setMessage(ex.getMessage());
        } catch (Exception ex) {
            response.setStatusCode(500);
            response.setMessage("Error: Finding booking by confirmation code" + ex.getMessage());
        }

        return response;
    }

    @Override
    public Response getAllBookings() {
        Response response = new Response();

        try {
            List<Booking> bookingList = bookingRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
            List<BookingDTO> bookingDTOList = Utils.mapBookingListEntityToBookingListDTO(bookingList);
            response.setStatusCode(200);
            response.setMessage("successful");
            response.setBookingList(bookingDTOList);

        } catch (ProjectException ex) {
            response.setStatusCode(404);
            response.setMessage(ex.getMessage());
        } catch (Exception ex) {
            response.setStatusCode(500);
            response.setMessage("Error: getting all bookings" + ex.getMessage());
        }

        return response;
    }

    @Override
    public Response cancelBooking(Long bookingId) {
        Response response = new Response();


        try {
            bookingRepository.findById(bookingId).orElseThrow(() -> new ProjectException("Booking not found"));
            bookingRepository.deleteById(bookingId);
            response.setStatusCode(200);
            response.setMessage("successful");
        } catch (ProjectException ex) {
            response.setStatusCode(404);
            response.setMessage(ex.getMessage());
        } catch (Exception ex) {
            response.setStatusCode(500);
            response.setMessage("Error: Cancel booking" + ex.getMessage());
        }
        return response;
    }
}
