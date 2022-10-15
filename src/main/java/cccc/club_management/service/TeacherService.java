package cccc.club_management.service;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeachers();
    Teacher getTeacherById(Long id) throws NotFoundException;
    void saveTeacher(Teacher teacher);
    void deleteTeacher(Long id) throws NotFoundException;
}