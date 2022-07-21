package uzb.hotel_register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uzb.hotel_register.peyload.ApiResponse;
import uzb.hotel_register.peyload.ReqRoom;
import uzb.hotel_register.service.RoomService;


@Controller
@RequestMapping(path = "/room")
public class RoomController {
    @Autowired
    RoomService roomService;

    @PostMapping
    public HttpEntity<?> eddRoom(@RequestBody ReqRoom reqRoom){
        ApiResponse apiResponse = roomService.addRoom(reqRoom);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editRoom(@PathVariable Integer id, @RequestBody ReqRoom reqRoom){
        ApiResponse apiResponse = roomService.editRoom(id, reqRoom);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteRoom(@PathVariable Integer id){
        return ResponseEntity.ok(roomService.deleteRoom(id));
    }

    @GetMapping("/list")
    public HttpEntity<?> getRoomList(){
        return ResponseEntity.ok(roomService.getRoomList());
    }
}
