package uzb.hotel_register.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer roomNumber;

    @ManyToOne
    private RoomType roomType;

    private Integer roomSize;

    private double priceDay;

    private double priceTime;

}
