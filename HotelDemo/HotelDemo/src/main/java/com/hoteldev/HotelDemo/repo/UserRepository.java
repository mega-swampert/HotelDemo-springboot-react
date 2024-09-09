package com.hoteldev.HotelDemo.repo;

import com.hoteldev.HotelDemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.print.DocFlavor;
import java.util.Optional;

/**
 * ClassName: UserRepository
 * Package: com.hoteldev.HotelDemo.repo
 * Description:
 *
 * @Author MegaSwampert
 * @Create 5/09/2024 1:19 pm
 * @Version 1.0
 */
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

}
