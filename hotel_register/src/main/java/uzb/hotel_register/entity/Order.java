package uzb.hotel_register.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Order {//Ozod qora gentro 707
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private User user;

    @OneToOne
    private Room room;

    @Column(nullable = false)
    @CreationTimestamp
    private Timestamp createDay;

    @Column(nullable = false)
    private Integer expireDay;

    @Column(nullable = false)
    private String time;
}
