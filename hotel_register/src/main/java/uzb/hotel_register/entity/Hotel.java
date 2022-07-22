package uzb.hotel_register.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uzb.hotel_register.entity.template.AbsNameEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Hotel extends AbsNameEntity {//Shxribonu
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

    @OneToMany
    private List<AwareHotel> awareHotels;

    private String description;
}
