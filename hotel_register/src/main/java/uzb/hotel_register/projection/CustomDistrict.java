package uzb.hotel_register.projection;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import uzb.hotel_register.entity.District;

@Projection(name = "customDistrict", types = District.class)
public interface CustomDistrict {
    Integer getId();
    String getName();
    @Value("#{target.region.id}")
    Integer getRegionId();
}
