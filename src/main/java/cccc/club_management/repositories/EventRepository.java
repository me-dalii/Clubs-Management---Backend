package cccc.club_management.repositories;

import cccc.club_management.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByClubId(Long id);
    List<Event> findAllByStatusTrue();
    List<Event> findAllByStatusNull();
    List<Event> findAllByStatusFalse();

    Long countAllByStatusTrue();

}