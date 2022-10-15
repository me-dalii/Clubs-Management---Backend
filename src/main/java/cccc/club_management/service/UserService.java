package cccc.club_management.service;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUserById(Long id) throws NotFoundException;
    User saveUser(User user);
    void deleteUser(Long id) throws NotFoundException;
}
