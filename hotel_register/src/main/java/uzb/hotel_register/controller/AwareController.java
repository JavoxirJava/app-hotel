package uzb.hotel_register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uzb.hotel_register.peyload.ApiResponse;
import uzb.hotel_register.peyload.ReqAware;
import uzb.hotel_register.peyload.ResAware;
import uzb.hotel_register.repository.AwareRepository;

import java.util.List;


@Controller
@RequestMapping(path = "/aware")
public class AwareController {
    @Autowired
    AwareService awareService;
    @Autowired
    AwareRepository awareRepository;

    @GetMapping
    public String getAware(){
        return "aware";
    }

    @PostMapping
    public HttpEntity<?> addAware(@RequestBody ReqAware reqAware) {
        ApiResponse apiResponse = awareService.saveAware(reqAware);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.CREATED : HttpStatus.CONFLICT).body(apiResponse);
    }


    @GetMapping("/list")
    public HttpEntity<?> getAwareList() {
        List<ResAware> awareList = awareService.getAwareList();
        return ResponseEntity.ok(awareList);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteAware(@PathVariable Integer id) {
        ApiResponse apiResponse = awareService.deleteAware(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editAware(@PathVariable Integer id, @RequestBody ReqAware reqAware){
        return ResponseEntity.ok(awareService.editAware(id,reqAware));
    }
}
