package com.filipem.projeto.pr1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filipem.projeto.pr1.entity.User;
import com.filipem.projeto.pr1.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(Integer id){
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(Integer id, User user){
        User updatedUser = userRepository.findById(id).orElse(null);
        if(updatedUser != null){
            updatedUser.setUserName(user.getUserName());
            updatedUser.setUserEmail(user.getUserEmail());
            return userRepository.save(updatedUser);
        }else{
            return null;
        }
    }

    public Boolean deleteUser(Integer id){
        User user = userRepository.findById(id).orElse(null);
        if(user!=null){
            userRepository.delete(user);
            return true;
        }else{
            return false;
        }
    }

}
