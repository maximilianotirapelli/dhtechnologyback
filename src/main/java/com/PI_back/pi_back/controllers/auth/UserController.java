package com.PI_back.pi_back.controllers.auth;

import com.PI_back.pi_back.controllers.Product.ProductoController;
import com.PI_back.pi_back.model.User;
import com.PI_back.pi_back.services.impl.UserServiceImplement;
import com.PI_back.pi_back.utils.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserServiceImplement userServiceImplement;
    @Autowired
    private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @GetMapping
    public ResponseEntity<List<User>> listOfUsers(){
        return ResponseEntity.ok(userServiceImplement.listUsers());
    }

    @PutMapping("/update/{email}")
    public void updateUser(@PathVariable String email, @RequestBody Role rol){
        userServiceImplement.updateByEmail(email, rol);
    }
}
