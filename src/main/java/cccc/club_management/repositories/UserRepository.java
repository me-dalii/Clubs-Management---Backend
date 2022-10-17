package cccc.club_management.repositories;

import cccc.club_management.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByAccount_Username(String username);
}
