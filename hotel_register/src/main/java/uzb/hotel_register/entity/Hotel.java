package uzb.hotel_register.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uzb.hotel_register.entity.template.AbsNameEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Hotel extends AbsNameEntity {
    @OneToOne
    private Contact contact;

    @Column(nullable = false)
    private Date foundDate;

    @Column(nullable = false)
    private Date licenseDate;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    @Column(nullable = false)
    private Date licenseExpire;

    @ManyToOne
    private BusinessType businessType;

    @OneToMany
    private List<AwareHotel> awareHotels;

    @OneToMany
    private List<Room> rooms;

    private String description;
}
