package crud.application.repositories;

import crud.application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Integer> {
    //JPA implements this automatically using the name of the method
    UserDetails findByEmail(String username);
}
