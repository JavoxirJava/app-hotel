package uzb.hotel_register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import uzb.hotel_register.entity.District;
import uzb.hotel_register.peyload.ApiResponse;
import uzb.hotel_register.peyload.ReqDistrict;
import uzb.hotel_register.peyload.ResDistrict;
import uzb.hotel_register.repository.DistrictRepository;
import uzb.hotel_register.service.DistrictService;

import java.util.List;


@RestController
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    DistrictService districtService;
    @Autowired
    DistrictRepository districtRepository;

    @GetMapping
    public HttpEntity<?> getDistrictList(){
        List<ResDistrict> districtList = districtService.getDistrictList();
        return ResponseEntity.ok(districtList);
    }


    @PostMapping
    public HttpEntity<?> addDistrict(@RequestBody ReqDistrict reqDistrict){
        ApiResponse apiResponse = districtService.addDistrict(reqDistrict);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }


    @PutMapping("/{id}")
    public HttpEntity<?> editDistrict(@PathVariable Integer id, @RequestBody ReqDistrict reqDistrict){
        ApiResponse apiResponse = districtService.editDistrict(id, reqDistrict);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }


    @DeleteMapping("/{id}")
    private HttpEntity<?> deleteDistrict(@PathVariable Integer id){
        ApiResponse apiResponse = districtService.deleteDistrict(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST).body(apiResponse);
    }
}
