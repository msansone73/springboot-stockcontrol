package br.com.msansone.stockcontrol.service;

import br.com.msansone.stockcontrol.model.db.User;

import java.util.List;

public interface UserService {
    User login(String name, String password);

    List<User> getAll();

    User add(User newUser);
}
