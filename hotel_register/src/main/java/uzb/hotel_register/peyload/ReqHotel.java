package uzb.hotel_register.peyload;

import lombok.Data;

import java.util.List;

@Data
public class ReqHotel {

    private String name;
    private ReqContact reqContact;
    private String foundDate;
    private String licenseDate;
    private String licenseNumber;
    private String licenseExpire;
    private Integer businessTypeId;
    private List<Integer> awareHotelIds;
    private ReqRoom reqRoom;
    private String description;
}
