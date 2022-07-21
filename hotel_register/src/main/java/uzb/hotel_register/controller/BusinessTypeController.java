package uzb.hotel_register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uzb.hotel_register.peyload.ApiResponse;
import uzb.hotel_register.peyload.ReqBusinessType;
import uzb.hotel_register.repository.BusinessTypeRepository;


@RestController
@RequestMapping(path = "/businessType")

public class BusinessTypeController {
    @Autowired
    BusinessTypeService businessTypeService;
    @Autowired
    BusinessTypeRepository businessTypeRepository;

    @PostMapping
    public HttpEntity<?> addBusinessType(@RequestBody ReqBusinessType reqBusinessType){
        ApiResponse apiResponse = businessTypeService.addBusinessType(reqBusinessType);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editBusinessType(@PathVariable Integer id, @RequestBody ReqBusinessType reqBusinessType){
        ApiResponse apiResponse = businessTypeService.editBusinessType(id, reqBusinessType);
        return ResponseEntity.status(apiResponse.isSuccess() ? 200 : 400 ).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteBusinessType(@PathVariable Integer id){
        return ResponseEntity.ok(businessTypeService.deleteBusinessType(id));
    }

    @GetMapping
    public HttpEntity<?> getBusinessTypeList(){
        return ResponseEntity.ok(businessTypeService.getBusinessTypeList());
    }
}
