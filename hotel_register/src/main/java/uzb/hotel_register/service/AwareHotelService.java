package uzb.hotel_register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uzb.hotel_register.entity.AwareHotel;
import uzb.hotel_register.peyload.ApiResponse;
import uzb.hotel_register.peyload.ReqAwareHotel;
import uzb.hotel_register.peyload.ResAwareHotel;
import uzb.hotel_register.repository.AwareHotelRepository;
import uzb.hotel_register.repository.AwareRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class AwareHotelService {
    @Autowired
    AwareHotelRepository awareHotelRepository;
    @Autowired
    AwareRepository awareRepository;

    public ApiResponse addAwareHotel(ReqAwareHotel reqAwareHotel) {
        if (!awareHotelRepository.existsAwareHotelByLinkEqualsIgnoreCase(reqAwareHotel.getLink())) {
            AwareHotel awareHotel = new AwareHotel();
            awareHotel.setLink(reqAwareHotel.getLink());
            awareHotel.setAware(awareRepository.findById(reqAwareHotel.getAwareId()).get());
            awareHotelRepository.save(awareHotel);
            return new ApiResponse("Successfully saved", true);
        }
        return new ApiResponse("This link already exist", false);
    }

    public ApiResponse editAwareHotel(Integer id, ReqAwareHotel reqAwareHotel) {
        if (!awareHotelRepository.existsAwareHotelByLinkEqualsIgnoreCase(reqAwareHotel.getLink())) {
            AwareHotel awareHotel = awareHotelRepository.findById(id).get();
            awareHotel.setLink(reqAwareHotel.getLink());
            awareHotel.setAware(awareRepository.findById(reqAwareHotel.getAwareId()).get());
            awareHotelRepository.save(awareHotel);
            return new ApiResponse("Successfully edit", true);
        }
        return new ApiResponse("This link already exist", false);
    }

    public ApiResponse deleteAwareHotel(Integer id) {
        awareHotelRepository.deleteById(id);
        return new ApiResponse("Successfully delete", true);
    }

    public List<ResAwareHotel> getAwareHotelList() {
        List<ResAwareHotel> resAwareHotelList = new ArrayList<>();
        List<AwareHotel> hotelList = awareHotelRepository.findAll();
        Integer tr = 0;
        for (AwareHotel awareHotel : hotelList) {
            tr++;
            ResAwareHotel resAwareHotel = new ResAwareHotel();
            resAwareHotel.setTr(tr);
            resAwareHotel.setId(awareHotel.getId());
            resAwareHotel.setLink(awareHotel.getLink());
            resAwareHotel.setAwareId(awareHotel.getAware().getId());
            resAwareHotel.setAwareName(awareHotel.getAware().getName());
            resAwareHotelList.add(resAwareHotel);
        }
        return resAwareHotelList;
    }
}
