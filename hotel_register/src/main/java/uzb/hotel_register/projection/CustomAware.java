package uzb.hotel_register.projection;

import org.springframework.data.rest.core.config.Projection;
import uzb.hotel_register.entity.Aware;

@Projection(name = "customAware", types = Aware.class)
public interface CustomAware {
    Integer getId();
    String getName();
}
