package uzb.hotel_register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uzb.hotel_register.entity.Region;
import uzb.hotel_register.peyload.ApiResponse;
import uzb.hotel_register.peyload.ReqRegion;
import uzb.hotel_register.peyload.ResRegion;
import uzb.hotel_register.repository.RegionRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class RegionService {
    @Autowired
    RegionRepository regionRepository;

    public ApiResponse addRegion(ReqRegion reqRegion){
        if(!regionRepository.existsRegionByNameEqualsIgnoreCase(reqRegion.getName())){
            Region region = new Region();
            region.setName(region.getName());
            regionRepository.save(region);
            return new ApiResponse("Successfully saved" ,true);
        }
            return new ApiResponse("This region already exist", false);
    }

    public ApiResponse editRegion(Integer id, ReqRegion reqRegion){
        if(!regionRepository.existsRegionByNameEqualsIgnoreCase(reqRegion.getName())){
            Region region = regionRepository.findById(id).get();
            region.setName(region.getName());
            regionRepository.save(region);
            return new ApiResponse("Successfully edit", true);
        }
            return new ApiResponse("This region already exist", false);
    }

    public ApiResponse deleteRegion(Integer id){
        regionRepository.deleteById(id);
        return new ApiResponse("Successfully delete", true);
    }


    public List<ResRegion> getRegionList(){
        List<ResRegion> resRegionList = new ArrayList<>();
        List<Region> regionList = regionRepository.findAll();
        Integer tr = 0;
        for(Region region : regionList){
            tr++;
            ResRegion resRegion = new ResRegion();
            resRegion.setTr(tr);
            resRegion.setId(region.getId());
            resRegion.setName(region.getName());
            resRegionList.add(resRegion);
        }
        return resRegionList;
    }
}
