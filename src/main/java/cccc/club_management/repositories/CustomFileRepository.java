package cccc.club_management.repositories;

import cccc.club_management.models.CustomFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomFileRepository extends JpaRepository<CustomFile, Long> {
}
