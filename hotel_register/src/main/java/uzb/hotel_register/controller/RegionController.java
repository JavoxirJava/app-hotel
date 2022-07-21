package uzb.hotel_register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uzb.hotel_register.peyload.ApiResponse;
import uzb.hotel_register.peyload.ReqRegion;
import uzb.hotel_register.repository.RegionRepository;
import uzb.hotel_register.service.RegionService;


@Controller
@RequestMapping(path = "/region")

public class RegionController {
    @Autowired
    RegionService regionService;
    @Autowired
    RegionRepository regionRepository;

    @GetMapping
    public String getRegion(){
        return "region";
    }

    @PostMapping
    public HttpEntity<?> addRegion(@RequestBody ReqRegion reqRegion){
        ApiResponse apiResponse = regionService.addRegion(reqRegion);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editRegion(@PathVariable Integer id , @RequestBody ReqRegion reqRegion){
        ApiResponse apiResponse = regionService.editRegion(id, reqRegion);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.CONFLICT).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteRegion(@PathVariable Integer id){
        ApiResponse apiResponse = regionService.deleteRegion(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST).body(apiResponse);
    }



    @GetMapping("/list")
    public HttpEntity<?> getRegionList(){
        return ResponseEntity.ok(regionService.getRegionList());
    }
}
