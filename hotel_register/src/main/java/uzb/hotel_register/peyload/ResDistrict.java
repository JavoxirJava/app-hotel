package uzb.hotel_register.peyload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResDistrict {

    private Integer tr;

    private Integer id;

    private String name;

    private Integer regionId;

    private String  regionName;


}
