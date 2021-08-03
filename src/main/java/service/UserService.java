package service;

import interfaceService.InterfaceUserService;
import interfaces.InterfaceUser;
import model.User;
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
    public Optional<User> getById(int id) {
        return Optional.empty();
    }

    @Override
    public int save(User u) {
        return 0;
    }

    @Override
    public void delete(int id) {

    }
}
