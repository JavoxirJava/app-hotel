package uzb.hotel_register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uzb.hotel_register.peyload.ApiResponse;
import uzb.hotel_register.service.HotelInfoService;

@Controller
@RequestMapping(path = "/hotelInfo")
public class HotelInfoController {
    @Autowired
    HotelInfoService hotelInfoService;

    @PostMapping
    public HttpEntity<?> eddHotelInfo(@RequestBody ReqHotelInfo reqHotelInfo){
        ApiResponse apiResponse = hotelInfoService.addHotelInfo(reqHotelInfo);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editHotelInfo(@PathVariable Integer id, @RequestBody ReqHotelInfo reqHotelInfo){
        ApiResponse apiResponse = hotelInfoService.editHotelInfo(id, reqHotelInfo);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteHotelInfo(@PathVariable Integer id){
        return ResponseEntity.ok(hotelInfoService.deleteHotelInfo(id));
    }

    @GetMapping("/list")
    public HttpEntity<?> getHotelInfoList(){
        return ResponseEntity.ok(hotelInfoService.getHotelInfoList());
    }
}
