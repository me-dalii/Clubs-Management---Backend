package cccc.club_management.service.impl;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.User;
import cccc.club_management.repositories.RoleRepository;
import cccc.club_management.repositories.UserRepository;
import cccc.club_management.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) throws NotFoundException {
        if(this.userRepository.findById(id).isPresent()) {
            return this.userRepository.findById(id).get();
        }else{
            throw new NotFoundException();
        }
    }

    @Override
    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) throws NotFoundException {
        if(this.userRepository.existsById(id)) {
            this.userRepository.deleteById(id);
        }else{
            throw new NotFoundException();
        }
    }
}
