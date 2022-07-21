package uzb.hotel_register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzb.hotel_register.entity.Room;


public interface RoomRepository extends JpaRepository<Room, Integer> {
    boolean existsByRoomNumberEquals(Integer roomNumber);
}
