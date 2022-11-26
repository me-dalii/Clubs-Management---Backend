package cccc.club_management.repositories;

import cccc.club_management.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllByClubNull();
    Long countAllByClubNotNull();

}