package com.accenture.Academic.service;

import com.accenture.Academic.interfaceService.InterfaceUserService;
import com.accenture.Academic.interfaces.InterfaceUser;
import com.accenture.Academic.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements InterfaceUserService {

    @Autowired
    private InterfaceUser data;

    @Override
    public List<User> get() {

        return (List<User>) data.findAll();
    }

    @Override
    public Optional<User> getById(int idUser) {  	
        return data.findById(idUser);
    }

    @Override
    public int save(User u) {
        int res=0;
        User user = data.save(u);
        if(!user.equals(null)){
            res=1;
        }
        return res;
    }

    @Override
    public void delete(int idUser) {
    	data.deleteById(idUser);
    } 
}
