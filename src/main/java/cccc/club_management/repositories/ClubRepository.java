package cccc.club_management.repositories;

import cccc.club_management.models.Club;
import cccc.club_management.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    Club findByLeader(User leader);
}