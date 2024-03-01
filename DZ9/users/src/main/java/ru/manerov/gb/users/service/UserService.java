package ru.manerov.gb.users.service;

import org.springframework.stereotype.Service;
import ru.manerov.gb.users.model.User;
import ru.manerov.gb.users.repositories.UserRepository;

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
       return userRepository.getOne(id);
    }

    public User updateUser(User user){
        return userRepository.updateUser(user);
    }
}
