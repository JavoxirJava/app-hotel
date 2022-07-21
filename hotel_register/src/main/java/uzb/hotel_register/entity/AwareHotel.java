package uzb.hotel_register.entity;


import lombok.Data;


import javax.persistence.*;

@Data
@Entity
public class AwareHotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String link;

    @ManyToOne
    private Aware aware;
}
