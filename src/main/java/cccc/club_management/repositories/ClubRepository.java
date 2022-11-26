package cccc.club_management.repositories;

import cccc.club_management.models.Club;
import cccc.club_management.models.Event;
import cccc.club_management.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    Club findByLeader(User leader);
    List<Club> findAllByLeaderAccountStatusTrue();
    Long countAllByLeaderAccountStatusTrue();
    Long countAllByLeaderAccountStatusNull();

}