package ia.eu.code.Repository;

import ia.eu.code.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String string);
}
