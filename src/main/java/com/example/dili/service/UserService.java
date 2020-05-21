package com.example.dili.service;

import com.example.dili.model.ResponseStatus;
import com.example.dili.model.User;
import com.example.dili.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseStatus registerUser(User userInfo) {
        if (userRepository.existsById(userInfo.getID())) {
            return new ResponseStatus(false, "Same ID has existed.");
        } else {
            User duplicate = userRepository.findUserByEmail(userInfo.getEmail());
            if(duplicate!=null){
                return new ResponseStatus(false, "Same email has existed.");
            }
            if (userRepository.save(userInfo) == null) {
                return new ResponseStatus(false, "Save failed.");
            } else {
                return new ResponseStatus(true, "Succeed.");
            }
        }
    }

    public Object loginUser(User userInfo) {
        User realUserInfo = userRepository.findUserByEmail(userInfo.getEmail());

        if (realUserInfo != null) {
            if(realUserInfo.getPassword().equals(userInfo.getPassword())) {
                return realUserInfo;
            }else{
                return new ResponseStatus(false, "Email or Password is wrong.");
            }
        } else {
            return new ResponseStatus(false, "Account do not exist");
        }
    }

    public ResponseStatus removeUser(int id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return new ResponseStatus(true, "Succeed.");
        }else {
            return new ResponseStatus(false, "Item does not exist.");
        }
    }
}
