package cccc.club_management.controllers;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Role;
import cccc.club_management.models.Teacher;
import cccc.club_management.service.RoleService;
import cccc.club_management.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/")
    public List<Teacher> getTeachers(){
        return teacherService.getTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return teacherService.getTeacherById(id);
    }

    @PostMapping("/")
    public void saveTeacher(@RequestBody Teacher teacher){
        teacherService.saveTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable(name = "id") Long id) throws NotFoundException {
        teacherService.deleteTeacher(id);
    }
}
