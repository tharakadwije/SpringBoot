package com.tharakadwije.rest.restfulwebservices.dao;


import com.tharakadwije.rest.restfulwebservices.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static ArrayList<User> listOfUser = new ArrayList<>();

    private int userCount =3;

    static {
        listOfUser.add(new User(1,"Tharaka", new Date()));
        listOfUser.add(new User(2,"Panchi", new Date()));
        listOfUser.add(new User(3,"Aki", new Date()));
    }

    public List<User> findAllUsers(){
        return listOfUser;
    }

    public User saveUser(User user){
        if(user.getId()==null){
            user.setId(++userCount);
        }
        listOfUser.add(user);
        return user;
    }


    public User findUser(int id){

        for(User user:listOfUser){
            if(user.getId()==id){
                return user;
            }
        }
        return null;
    }

    public User deleteByUser(int id) {

        Iterator iterator = listOfUser.iterator();

        while (iterator.hasNext()) {

            User u = (User) iterator.next();

            if (u.getId() == id)
             listOfUser.remove(u);
               // iterator.remove();
             return u;
        }
        return null;
    }

}
