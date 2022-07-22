package uzb.hotel_register.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.NonComposite;


import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AwareHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String link;

    @ManyToOne
    private Aware aware;

}
