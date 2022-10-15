package cccc.club_management.controllers;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Club;
import cccc.club_management.models.Department;
import cccc.club_management.service.ClubService;
import cccc.club_management.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/")
    public void saveDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable(name = "id") Long id) throws NotFoundException {
        departmentService.deleteDepartment(id);
    }
}
