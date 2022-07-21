package uzb.hotel_register.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import uzb.hotel_register.entity.template.AbsNameEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;



@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class District extends AbsNameEntity {

    @ManyToOne(optional = false)
    private Region region;
}
