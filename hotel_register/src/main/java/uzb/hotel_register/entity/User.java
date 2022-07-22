package uzb.hotel_register.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uzb.hotel_register.entity.enums.Gender;
import uzb.hotel_register.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbsEntity implements UserDetails {// Shahzod aka, Odil aka va Ozod 2 mazzami👍👍👍😂😂

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String passwordNumber;

    @OneToOne
    private Contact contact;

    @Column(nullable = false)
    private String password;

    @OneToMany
    private List<Role> roles;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return contact.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
