package Hospital.Management.Hospital.Management.Repository;

import Hospital.Management.Hospital.Management.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findUserByUsername(String username);
    boolean existsByUsername(String username);
}
