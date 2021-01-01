package com.tharakadwije.rest.restfulwebservices.user;


import com.tharakadwije.rest.restfulwebservices.dao.UserDaoService;
import com.tharakadwije.rest.restfulwebservices.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDaoService userDaoService;


    @GetMapping(path = "/users")
    public List<User> userList(){
        return userDaoService.findAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public User findUser(@PathVariable int id){
        User usr = (User) userDaoService.findUser(id);

        if(usr==null){
            throw new UserNotFoundException("id -"+id);
        }
        return  usr;
    }



    @PostMapping(path = "/users")
    public ResponseEntity saveUser(@RequestBody  User user){
        User u = userDaoService.saveUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(u.getId()).toUri();

       return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public User deleteUser(@PathVariable int id){
        User usr = (User) userDaoService.deleteByUser(id);

        if(usr==null){
            throw new UserNotFoundException("id -"+id);
        }
        return  usr;
    }
}
