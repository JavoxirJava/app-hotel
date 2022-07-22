package uzb.hotel_register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzb.hotel_register.entity.RoomType;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {
}
