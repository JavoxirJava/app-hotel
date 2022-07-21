package uzb.hotel_register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uzb.hotel_register.entity.District;
import uzb.hotel_register.entity.Region;
import uzb.hotel_register.peyload.ApiResponse;
import uzb.hotel_register.peyload.ReqDistrict;
import uzb.hotel_register.peyload.ResDistrict;
import uzb.hotel_register.repository.DistrictRepository;
import uzb.hotel_register.repository.RegionRepository;


import java.util.ArrayList;
import java.util.List;


@Service
public class DistrictService {

    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    RegionRepository regionRepository;

    public ApiResponse addDistrict(ReqDistrict reqDistrict){
        if(!districtRepository.existsDistrictByNameEqualsIgnoreCase(reqDistrict.getName())){
            District district = new District();
            district.setName(reqDistrict.getName());
            Region region = regionRepository.findRegionById(reqDistrict.getRegionId());
            district.setRegion(region);
            districtRepository.save(district);
            return new ApiResponse("Successfully district saved",true);
        }
            return new ApiResponse("District name already exist",false);
    }


    public List<ResDistrict> getDistrictList(){
        List<ResDistrict> resDistrictList = new ArrayList<>();
        List<District> districtList = districtRepository.findAll();
        Integer tr = 0;
        for(District district : districtList){
            tr++;
            ResDistrict resDistrict = new ResDistrict();
            resDistrict.setTr(tr);
            resDistrict.setId(district.getId());
            resDistrict.setName(district.getName());
            resDistrict.setRegionId(district.getRegion().getId());
            resDistrictList.add(resDistrict);
        }
        return resDistrictList;
    }


    public ApiResponse editDistrict(Integer id, ReqDistrict reqDistrict){
            if(!districtRepository.existsDistrictByNameEqualsIgnoreCase(reqDistrict.getName())){
                District district = districtRepository.findById(id).get();
                district.setName(reqDistrict.getName());
                Region region = regionRepository.findById(reqDistrict.getRegionId()).get();
                district.setRegion(region);
                districtRepository.save(district);
                return new ApiResponse("Successfully edit district", true);
            }
                return new ApiResponse("District name already exist" , false);

    }


    public ApiResponse deleteDistrict(Integer id){
        districtRepository.deleteById(id);
        return new ApiResponse("Delete district", true);
    }



}
