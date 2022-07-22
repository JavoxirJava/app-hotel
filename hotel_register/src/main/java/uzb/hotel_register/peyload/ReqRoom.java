package uzb.hotel_register.peyload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReqRoom {
    private Integer hotelId;
    private Integer roomNumber;
    private Integer roomTypeId;
    private Integer roomSize;
    private double priceDay;
    private double priceTime;
}
