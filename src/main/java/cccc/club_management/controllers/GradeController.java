package cccc.club_management.controllers;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Department;
import cccc.club_management.models.Grade;
import cccc.club_management.service.DepartmentService;
import cccc.club_management.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/")
    public List<Grade> getGrades(){
        return gradeService.getGrades();
    }

    @GetMapping("/{id}")
    public Grade getGradeById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return gradeService.getGradeById(id);
    }

    @PostMapping("/")
    public void saveDGrade(@RequestBody Grade grade){
        gradeService.saveGrade(grade);
    }

    @DeleteMapping("/{id}")
    public void deleteGrade(@PathVariable(name = "id") Long id) throws NotFoundException {
        gradeService.deleteGrade(id);
    }
}
