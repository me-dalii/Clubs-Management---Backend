package cccc.club_management.service.impl;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Role;
import cccc.club_management.repositories.EventRepository;
import cccc.club_management.repositories.RoleRepository;
import cccc.club_management.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class RoleServiceImpl implements RoleService {

    /*@Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getRoles() {
        return this.roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) throws NotFoundException {
        if(this.roleRepository.findById(id).isPresent()) {
            return this.roleRepository.findById(id).get();
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public void saveRole(Role role) {
        this.roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) throws NotFoundException {
        if(this.roleRepository.existsById(id)) {
            this.roleRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }*/
}
