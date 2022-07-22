package uzb.hotel_register.peyload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResRoom {
    private Integer tr;
    private Integer id;
    private Integer hotelId;
    private Integer roomTypeId;
    private Integer roomNumber;
    private Integer roomSize;
    private double priceDay;
    private double priceTime;


}
