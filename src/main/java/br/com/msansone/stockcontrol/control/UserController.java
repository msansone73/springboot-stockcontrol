package br.com.msansone.stockcontrol.control;

import br.com.msansone.stockcontrol.model.db.User;
import br.com.msansone.stockcontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User newUser){
        User user= userService.add(newUser);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User userLogin){
        User user = userService.login(userLogin.getEmail(), userLogin.getPassword());
        if (user==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }


}
