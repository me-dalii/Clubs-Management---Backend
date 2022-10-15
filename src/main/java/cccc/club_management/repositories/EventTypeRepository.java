package cccc.club_management.repositories;

import cccc.club_management.models.EventType;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EventTypeRepository extends JpaRepository<EventType, Long> {
}