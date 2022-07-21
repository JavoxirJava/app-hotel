package uzb.hotel_register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uzb.hotel_register.entity.District;
import uzb.hotel_register.projection.CustomDistrict;

@RepositoryRestResource(path = "district", collectionResourceRel = "list", excerptProjection = CustomDistrict.class)
public interface DistrictRepository extends JpaRepository<District, Integer> {
}
