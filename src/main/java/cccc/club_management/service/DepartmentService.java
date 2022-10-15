package cccc.club_management.service;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartments();
    Department getDepartmentById(Long id) throws NotFoundException;
    void saveDepartment(Department department);
    void deleteDepartment(Long id) throws NotFoundException;
}
