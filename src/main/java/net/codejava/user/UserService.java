package net.codejava.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository repo;
    


    public User getUserByUserName(String username) {
        return repo.getUserByUsername(username);
    }

    public User saveNewUser(User newUser) {
        return repo.save(newUser);
    }
}
