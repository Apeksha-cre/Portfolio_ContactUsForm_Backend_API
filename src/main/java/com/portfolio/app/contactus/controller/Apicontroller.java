package com.portfolio.app.contactus.controller;

import com.portfolio.app.contactus.Repo.UserRepo;
import com.portfolio.app.contactus.models.ApiUser;
import com.portfolio.app.contactus.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class Apicontroller
{
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getpages()
    {
        return "welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers()
    {
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveusers(@RequestBody ApiUser user)
    {
      User entityUser =  mapApiUaerToEntityUser(user);
       userRepo.save(entityUser);
       return "save";
    }

    private User mapApiUaerToEntityUser(ApiUser user) {

        User entityUser= new User();
        entityUser.setName(user.getUname());
        entityUser.setEmail(user.getEmail());
        entityUser.setSubject(user.getSubject());
        entityUser.setMessage(user.getMessage());
        return entityUser;
    }


}
