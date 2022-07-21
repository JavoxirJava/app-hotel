package uzb.hotel_register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uzb.hotel_register.entity.BusinessType;
import uzb.hotel_register.projection.CustomAware;
import uzb.hotel_register.projection.CustomBusinessType;

@RepositoryRestResource(path = "businessType", collectionResourceRel = "list", excerptProjection = CustomBusinessType.class)
public interface BusinessTypeRepository extends JpaRepository<BusinessType, Integer> {
}
