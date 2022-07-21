package uzb.hotel_register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uzb.hotel_register.entity.Room;
import uzb.hotel_register.peyload.ApiResponse;
import uzb.hotel_register.peyload.ReqRoom;
import uzb.hotel_register.peyload.ResRoom;
import uzb.hotel_register.repository.RoomRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    public ApiResponse addRoom(ReqRoom reqRoom){
        if(!roomRepository.existsByRoomNumberEquals(reqRoom.getRoomNumber())){
            Room room = new Room();
            room.setRoomNumber(reqRoom.getRoomNumber());
            room.setCategoryRoomName(reqRoom.getCategoryRoomName());
            room.setRoomSize(reqRoom.getRoomSiz());
            room.setPriceDay(reqRoom.getPriceDay());
            room.setPriceTime(reqRoom.getPriceTime());
            roomRepository.save(room);
            return new ApiResponse("Successfully saved" ,true);
        }
            return new ApiResponse("This room already exist", false);
    }

    public ApiResponse editRoom(Integer id, ReqRoom reqRoom){
        if(!roomRepository.existsByRoomNumberEquals(reqRoom.getRoomNumber())){
            Room room = roomRepository.findById(id).get();
            room.setRoomNumber(reqRoom.getRoomNumber());
            room.setCategoryRoomName(reqRoom.getCategoryRoomName());
            room.setRoomSize(reqRoom.getRoomSiz());
            room.setPriceDay(reqRoom.getPriceDay());
            room.setPriceTime(reqRoom.getPriceTime());
            roomRepository.save(room);
            return new ApiResponse("Successfully edit" ,true);
        }
        return new ApiResponse("This room already exist", false);
    }

    public ApiResponse deleteRoom(Integer id){
        roomRepository.deleteById(id);
        return new ApiResponse("Successfully delete", true);
    }

    public List<ResRoom> getRoomList(){
        List<ResRoom> resRoomList = new ArrayList<>();
        List<Room> roomList = roomRepository.findAll();
        Integer tr = 0;
        for(Room room : roomList){
            tr++;
            ResRoom resRoom = new ResRoom();
            resRoom.setTr(tr);
            resRoom.setId(room.getId());
            resRoom.setRoomNumber(room.getRoomNumber());
            resRoom.setCategoryRoomName(room.getCategoryRoomName());
            resRoom.setRoomSiz(room.getRoomSize());
            resRoom.setPriceDay(room.getPriceDay());
            resRoom.setPriceTime(room.getPriceTime());
            resRoomList.add(resRoom);
        }
            return resRoomList;
    }
}
