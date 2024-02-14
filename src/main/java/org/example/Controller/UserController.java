package org.example.Controller;

import org.example.Model.User;
import org.example.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.userRegistration(user);
    }

    @PostMapping("/login")
    public String userLogin(@RequestBody User user) {
        String userName = user.getUsername();
        String password = user.getPassword1();
        return userService.userLogin(userName,password);
    }

    @PostMapping("/findById/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }
}
