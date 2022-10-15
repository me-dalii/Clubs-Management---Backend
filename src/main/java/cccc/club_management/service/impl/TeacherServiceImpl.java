package cccc.club_management.service.impl;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Teacher;
import cccc.club_management.repositories.EventRepository;
import cccc.club_management.repositories.TeacherRepository;
import cccc.club_management.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getTeachers() {
        return this.teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) throws NotFoundException {
        if(this.teacherRepository.findById(id).isPresent()) {
            return this.teacherRepository.findById(id).get();
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        this.teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacher(Long id) throws NotFoundException {
        if(this.teacherRepository.existsById(id)) {
            this.teacherRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }
}
