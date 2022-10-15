package cccc.club_management.controllers;

import cccc.club_management.exceptions.NotFoundException;
import cccc.club_management.models.Teacher;
import cccc.club_management.models.User;
import cccc.club_management.service.TeacherService;
import cccc.club_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(name = "id") Long id) throws NotFoundException {
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id) throws NotFoundException {
        userService.deleteUser(id);
    }
}
