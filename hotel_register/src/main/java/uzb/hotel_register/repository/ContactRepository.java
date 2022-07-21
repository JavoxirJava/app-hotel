package uzb.hotel_register.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzb.hotel_register.entity.Contact;

import java.util.UUID;

public interface ContactRepository extends JpaRepository<Contact, UUID> {
}
