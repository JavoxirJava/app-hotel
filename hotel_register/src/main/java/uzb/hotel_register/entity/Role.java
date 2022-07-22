package uzb.hotel_register.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import uzb.hotel_register.entity.enums.RoleName;


import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority{//Maqsud
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
