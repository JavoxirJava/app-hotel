package uzb.hotel_register.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uzb.hotel_register.entity.Aware;
import uzb.hotel_register.projection.CustomAware;

@RepositoryRestResource(path = "aware", collectionResourceRel = "list", excerptProjection = CustomAware.class)
public interface AwareRepository extends JpaRepository<Aware, Integer> {
}
