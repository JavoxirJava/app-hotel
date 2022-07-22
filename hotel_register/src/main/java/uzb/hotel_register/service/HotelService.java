package uzb.hotel_register.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
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
    final AwareRepository awareRepository;


    public HotelService(HotelRepository hotelRepository, ContactRepository contactRepository, DistrictRepository districtRepository, BusinessTypeRepository businessTypeRepository, AwareHotelRepository awareHotelRepository, AwareRepository awareRepository) {
        this.hotelRepository = hotelRepository;
        this.contactRepository = contactRepository;
        this.districtRepository = districtRepository;
        this.businessTypeRepository = businessTypeRepository;
        this.awareHotelRepository = awareHotelRepository;
        this.awareRepository = awareRepository;
    }

    public ApiResponse createHotel(ReqHotel reqHotel) throws ParseException {
        Hotel hotel = new Hotel();
        Contact contact = new Contact();
        AwareHotel awareHotel = new AwareHotel();
        addOrEdit(contact, reqHotel, hotel, awareHotel);
        return new ApiResponse("successfully saved Hotel", true);
    }



    public void addOrEdit(Contact contact, ReqHotel reqHotel, Hotel hotel, AwareHotel awareHotel) throws ParseException {
        List<AwareHotel> awareHotelList = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat();

        awareHotel.setAware(awareRepository.findById(reqHotel.getReqAwareHotel().getAwareId()).orElseThrow(() -> new ResourceAccessException("getAware")));
        awareHotel.setLink(reqHotel.getReqAwareHotel().getLink());
        AwareHotel awareHotelSave = awareHotelRepository.save(awareHotel);
        awareHotelList.add(awareHotelSave);

        contact.setAddress(reqHotel.getReqContact().getAddress());
        contact.setDistrict(districtRepository.findById(reqHotel.getReqContact().getDistrictId()).orElseThrow(() -> new ResourceAccessException("getDistrict")));
        contact.setEmail(reqHotel.getReqContact().getEmail());
        contact.setPhoneNumber(reqHotel.getReqContact().getPhoneNumber());
        hotel.setContact(contactRepository.save(contact));
        hotel.setName(reqHotel.getName());
        hotel.setFoundDate(dateFormat.parse(reqHotel.getFoundDate()));
        hotel.setLicenseDate(dateFormat.parse(reqHotel.getLicenseDate()));
        hotel.setLicenseNumber(reqHotel.getLicenseNumber());
        hotel.setLicenseExpire(dateFormat.parse(reqHotel.getLicenseExpire()));
        hotel.setAwareHotels(awareHotelList);
        hotel.setDescription(reqHotel.getDescription());
        hotelRepository.save(hotel);
    }
}
