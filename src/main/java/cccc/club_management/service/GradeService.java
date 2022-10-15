package cccc.club_management.service;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Grade;

import java.util.List;

public interface GradeService {
    List<Grade> getGrades();
    Grade getGradeById(Long id) throws NotFoundException;
    void saveGrade(Grade grade);
    void deleteGrade(Long id) throws NotFoundException;
}
