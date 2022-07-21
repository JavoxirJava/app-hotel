package uzb.hotel_register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzb.hotel_register.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
