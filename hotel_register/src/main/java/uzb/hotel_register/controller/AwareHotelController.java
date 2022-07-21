package uzb.hotel_register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uzb.hotel_register.peyload.ApiResponse;
import uzb.hotel_register.peyload.ReqAwareHotel;
import uzb.hotel_register.service.AwareHotelService;

@Controller
@RequestMapping(path = "/awareHotel")
public class AwareHotelController {
    @Autowired
    AwareHotelService awareHotelService;

    @PostMapping
    public HttpEntity<?> addAwareHotel(@RequestBody ReqAwareHotel reqAwareHotel){
        ApiResponse apiResponse = awareHotelService.addAwareHotel(reqAwareHotel);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editAwareHotel(@PathVariable Integer id, @RequestBody ReqAwareHotel reqAwareHotel){
        ApiResponse apiResponse = awareHotelService.editAwareHotel(id, reqAwareHotel);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteAwareHotel(@PathVariable Integer id){
        return ResponseEntity.ok(awareHotelService.deleteAwareHotel(id));
    }

    @GetMapping("/list")
    public HttpEntity<?> getAwareHotelList(){
        return ResponseEntity.ok(awareHotelService.getAwareHotelList());
    }
}
