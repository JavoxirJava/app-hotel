package uzb.hotel_register.peyload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResAwareHotel {

    private Integer tr;

    private Integer id;

    private String  link;

    private Integer awareId;

    private String awareName;
}
