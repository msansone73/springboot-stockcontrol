package br.com.msansone.stockcontrol.service;

import br.com.msansone.stockcontrol.model.db.User;
import br.com.msansone.stockcontrol.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository repo;

    @Override
    public User login(String email, String password) {
        List<User> users = repo.findAllByEmailAndPassword(email,password);
        if (users.isEmpty()){
            return null;
        }
        return users.get(0);
    }

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }

    @Override
    public User add(User newUser) {
        return repo.save(newUser);
    }
}
