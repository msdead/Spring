package DZ2.service;

import DZ2.model.User;
import DZ2.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    public User getOneUserByID(int id)  {
       return userRepository.findUser(id);
    }

    public void updateUser(User user){
        userRepository.updateUser(user, user.getId());
    }
}
