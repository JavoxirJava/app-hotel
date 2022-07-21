package uzb.hotel_register.service;

import org.springframework.stereotype.Service;
import uzb.hotel_register.entity.AwareHotel;
import uzb.hotel_register.entity.Contact;
import uzb.hotel_register.entity.Hotel;
import uzb.hotel_register.peyload.ApiResponse;
import uzb.hotel_register.peyload.ReqHotel;
import uzb.hotel_register.repository.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {
    final HotelRepository hotelRepository;
    final ContactRepository contactRepository;
    final DistrictRepository districtRepository;
    final BusinessTypeRepository businessTypeRepository;
    final AwareHotelRepository awareHotelRepository;


    public HotelService(HotelRepository hotelRepository, ContactRepository contactRepository, DistrictRepository districtRepository, BusinessTypeRepository businessTypeRepository, AwareHotelRepository awareHotelRepository) {
        this.hotelRepository = hotelRepository;
        this.contactRepository = contactRepository;
        this.districtRepository = districtRepository;
        this.businessTypeRepository = businessTypeRepository;
        this.awareHotelRepository = awareHotelRepository;
    }

    public ApiResponse createHotel(ReqHotel reqHotel) throws ParseException {
        Hotel hotel = new Hotel();
        Contact contact = new Contact();
        SimpleDateFormat dateFormat = new SimpleDateFormat();
        List<AwareHotel> awareHotelList =new ArrayList<>();

        for (Integer awareHotelId : reqHotel.getAwareHotelIds()) {
            awareHotelList.add(awareHotelRepository.findById(awareHotelId).get());
        }



        contact.setAddress(reqHotel.getReqContact().getAddress());
        contact.setDistrict(districtRepository.findById(reqHotel.getReqContact().getDistrictId()).get());
        contact.setEmail(reqHotel.getReqContact().getEmail());
        contact.setPhoneNumber(reqHotel.getReqContact().getPhoneNumber());
        hotel.setContact(contactRepository.save(contact));
        hotel.setName(reqHotel.getName());
        hotel.setFoundDate(dateFormat.parse(reqHotel.getFoundDate()));
        hotel.setLicenseDate(dateFormat.parse(reqHotel.getLicenseDate()));
        hotel.setLicenseNumber(reqHotel.getLicenseNumber());
        hotel.setLicenseExpire(dateFormat.parse(reqHotel.getLicenseExpire()));
        hotel.setBusinessType(businessTypeRepository.findById(reqHotel.getBusinessTypeId()).get());

        hotel.setAwareHotels(awareHotelList);

        //TODO loading...



        return null;




    }
}
