package uzb.hotel_register.projection;

import org.springframework.data.rest.core.config.Projection;
import uzb.hotel_register.entity.BusinessType;

@Projection(name = "customBusinessType", types = BusinessType.class)
public interface CustomBusinessType {
    Integer getId();
    String getName();
}
