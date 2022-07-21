package uzb.hotel_register.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import uzb.hotel_register.entity.template.AbsNameEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Aware extends AbsNameEntity {

}
