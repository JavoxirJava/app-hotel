package uzb.hotel_register.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Hotel hotel;

    private Integer roomNumber;

    @ManyToOne
    private RoomType roomType;

    private Integer roomSize;

    private double priceDay;

    private double priceTime;
}
