package cccc.club_management.service.impl;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Department;
import cccc.club_management.repositories.DepartmentRepository;
import cccc.club_management.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getDepartments() {
        return this.departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) throws NotFoundException {
        if(this.departmentRepository.findById(id).isPresent()) {
            return this.departmentRepository.findById(id).get();
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public void saveDepartment(Department department) {
        this.departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long id) throws NotFoundException {
        if(this.departmentRepository.existsById(id)) {
            this.departmentRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }
}
