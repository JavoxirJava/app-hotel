package uzb.hotel_register.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import uzb.hotel_register.entity.Room;
import uzb.hotel_register.peyload.ApiResponse;
import uzb.hotel_register.peyload.ReqRoom;
import uzb.hotel_register.peyload.ResRoom;
import uzb.hotel_register.repository.HotelRepository;
import uzb.hotel_register.repository.RoomRepository;
import uzb.hotel_register.repository.RoomTypeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    final RoomRepository roomRepository;
    final RoomTypeRepository roomTypeRepository;
    final HotelRepository hotelRepository;

    public RoomService(RoomRepository roomRepository, RoomTypeRepository roomTypeRepository, HotelRepository hotelRepository) {
        this.roomRepository = roomRepository;
        this.roomTypeRepository = roomTypeRepository;
        this.hotelRepository = hotelRepository;
    }

    public ApiResponse addRoom(ReqRoom reqRoom) {
        if (!roomRepository.existsByRoomNumberEquals(reqRoom.getRoomNumber())) {
            Room room = new Room();
            addOrEditRoom(room, reqRoom);
            return new ApiResponse("Successfully saved", true);
        }
        return new ApiResponse("This room already exist", false);
    }

    public ApiResponse editRoom(Integer id, ReqRoom reqRoom) {
        if (!roomRepository.existsByRoomNumberEquals(reqRoom.getRoomNumber())) {
            Room room = roomRepository.findById(id).orElseThrow(() -> new ResourceAccessException("getRoom"));
            addOrEditRoom(room, reqRoom);
            return new ApiResponse("Successfully edit", true);
        }
        return new ApiResponse("This room already exist", false);
    }

    public ApiResponse deleteRoom(Integer id) {
        roomRepository.deleteById(id);
        return new ApiResponse("Successfully delete", true);
    }

    public ResRoom getOneRoom(Room room, int tr) {
        return new ResRoom(
                tr,
                room.getId(),
                room.getId(),
                room.getRoomType().getId(),
                room.getRoomNumber(),
                room.getRoomSize(),
                room.getPriceDay(),
                room.getPriceTime()
        );
    }

    public List<ResRoom> getRoomList() {
        List<ResRoom> resRoomList = new ArrayList<>();
        List<Room> roomList = roomRepository.findAll();
        int tr = 0;
        for (Room room : roomList) {
            tr++;
            resRoomList.add(getOneRoom(room, tr));
        }
        return resRoomList;
    }

    public void addOrEditRoom(Room room, ReqRoom reqRoom) {
        room.setHotel(hotelRepository.findById(reqRoom.getHotelId()).orElseThrow(() -> new ResourceAccessException("getHotel")));
        room.setRoomNumber(reqRoom.getRoomNumber());
        room.setRoomType(roomTypeRepository.findById(reqRoom.getRoomTypeId()).orElseThrow(() -> new ResourceAccessException("getRoomType")));
        room.setRoomSize(reqRoom.getRoomSize());
        room.setPriceDay(reqRoom.getPriceDay());
        room.setPriceTime(reqRoom.getPriceTime());
        roomRepository.save(room);
    }
}
