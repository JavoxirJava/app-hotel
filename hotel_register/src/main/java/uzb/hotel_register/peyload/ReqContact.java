package uzb.hotel_register.peyload;

import lombok.Data;

import java.util.Set;

@Data
public class ReqContact {
    private Integer districtId;
    private String address;
    private Set<String> phoneNumber;
    private String email;
}
