package uzb.hotel_register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzb.hotel_register.entity.AwareHotel;

public interface AwareHotelRepository extends JpaRepository<AwareHotel, Integer> {
    boolean existsAwareHotelByLinkEqualsIgnoreCase(String link);
}
