package com.tharakadwije.rest.restfulwebservices.user;


import com.tharakadwije.rest.restfulwebservices.dao.UserDaoService;
import com.tharakadwije.rest.restfulwebservices.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.hateoas.EntityModel;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private MessageSource messageSource;


    @GetMapping(path = "/users")
    public List<User> userList(){
        return userDaoService.findAllUsers();
    }

    @GetMapping(path = "/users/{id}")
    public EntityModel<User> findUser(@PathVariable int id){
        User usr = (User) userDaoService.findUser(id);

        if(usr==null){
            throw new UserNotFoundException("id -"+id);
        }
        EntityModel<User> resource = EntityModel.of(usr);

        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).userList());

        resource.add(linkTo.withRel("all-users"));

        //HATEOAS
        return resource;


    }



    @PostMapping(path = "/users")
    public ResponseEntity saveUser(@Valid @RequestBody  User user){
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

    @GetMapping(path = "/users/internationalized")
    public String helloInternationalized(){
        return messageSource.getMessage("good.morning.msg",null, LocaleContextHolder.getLocale());
    }

}
