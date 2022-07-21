package uzb.hotel_register.entity;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import uzb.hotel_register.entity.enums.RoleName;


import javax.persistence.*;


@Data
@Entity
public class Role implements GrantedAuthority{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private RoleName roleName;


    @Override
    public String getAuthority() {
        return roleName.name();
    }
}
