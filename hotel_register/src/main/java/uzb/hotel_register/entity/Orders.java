package uzb.hotel_register.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private User user;

    @ManyToOne
    private Hotel hotel;

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
