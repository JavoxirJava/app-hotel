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

    private Integer roomNumber;

    private String categoryRoomName;

    private Integer roomSiz;

    private double priceDay;

    private double priceTime;

}
