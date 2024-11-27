package com.lino.hruser.Controllers;

import com.lino.hruser.entities.User;
import com.lino.hruser.repositories.USerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private USerRepository repository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {

        User obj = repository.findById(id).get();
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {

        User obj = repository.findByEmail(email);
        return ResponseEntity.ok().body(obj);
    }

}
