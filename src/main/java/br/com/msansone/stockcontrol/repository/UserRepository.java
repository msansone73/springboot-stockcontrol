package br.com.msansone.stockcontrol.repository;

import br.com.msansone.stockcontrol.model.db.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByEmailAndPassword(String email, String password);
}
