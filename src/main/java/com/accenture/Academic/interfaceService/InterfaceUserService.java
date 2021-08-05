package com.accenture.Academic.interfaceService;

import com.accenture.Academic.model.User;

import java.util.List;
import java.util.Optional;


public interface InterfaceUserService {
    public List<User> get();
    public Optional<User> getById(int id);
    public int save(User u);
    public void delete(int id);
}
