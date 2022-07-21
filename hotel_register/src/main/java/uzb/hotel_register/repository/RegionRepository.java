package uzb.hotel_register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzb.hotel_register.entity.Region;


public interface RegionRepository extends JpaRepository<Region, Integer> {
    Region findRegionById(Integer id);
    boolean existsRegionByNameEqualsIgnoreCase(String name);
}
