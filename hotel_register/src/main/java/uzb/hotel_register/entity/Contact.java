package uzb.hotel_register.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import uzb.hotel_register.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Contact extends AbsEntity {
    @ManyToOne(optional = false)
    private District district;

    @Column(nullable = false)
    private String address;

    @ElementCollection
    private Set<String> phoneNumber;

    @Column(nullable = false, unique = true)
    private String email;
}
