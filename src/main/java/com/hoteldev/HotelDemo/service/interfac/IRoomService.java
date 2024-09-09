package com.hoteldev.HotelDemo.service.interfac;

import com.hoteldev.HotelDemo.dto.Response;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * ClassName: IRoomService
 * Package: com.hoteldev.HotelDemo.service.interfac
 * Description:
 *
 * @Author MegaSwampert
 * @Create 6/09/2024 1:11 pm
 * @Version 1.0
 */
public interface
IRoomService {

    Response addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice, String description);

    List<String> getAllRoomTypes();

    Response getAllRooms();

    Response deleteRoom(Long roomId);

    Response updateRoom(Long roomId, String description, String roomType,BigDecimal roomPrice,MultipartFile photo);

    Response getRoomById(Long roomId);

    Response getAvailableRoomsByDateAndType(LocalDate checkInDate, LocalDate checkOutDate, String roomType);

    Response getAvailableRooms();

}
