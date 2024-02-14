package org.example.Service;

import org.example.Model.User;
import org.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private TokenService tokenService;

    public UserService(UserRepository userRepo, TokenService tokenService) {
        this.userRepo = userRepo;
        this.tokenService = tokenService;
    }
    public User userRegistration(User user) {
        return userRepo.save(user);
    }

    public String userLogin(String userName, String password) {
        boolean foundUsers = existByEmail(userName);
        if(foundUsers) {
            User user = userRepo.getUserByUserName(userName);
            if(user.getPassword1().equals(password)) {
                return "{" +
                        "\"message\" :"+"Successfully logged in\",\n"+
                        "\"data\" :"+user+",\n"+
                        "\"UserName: " + user.getUsername() + "\n"+
                        "\"token: " + tokenService.createTokenFunction(user.getId())+ "\" "+
                        "}";
            }
        }
        return "{" +
                "\"message\":"+"Authentication Failed\",\n"+
                "}";
    }
    public Boolean  existByEmail(String email){
        Optional<User> usersObj = Optional.ofNullable(userRepo.getUserByUserName(email));
//        System.out.println(usersObj);
        if(!usersObj.isEmpty()){
            return true;
        }
        return false;
    }

    public User getUserById(int id) {
        return userRepo.findById(id).get();
    }
}
