package uzb.hotel_register.peyload;

import lombok.Data;

@Data
public class ReqRoom {

    private Integer roomNumber;

    private Integer roomTypeId;

    private Integer roomSize;

    private double priceDay;

    private double priceTime;
}
