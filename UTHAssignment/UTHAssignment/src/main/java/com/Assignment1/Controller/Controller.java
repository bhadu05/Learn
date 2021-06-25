package com.Assignment1.Controller;

import com.Assignment1.Service.service;
import com.Assignment1.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    service service;

    //API which will create a user in the table.
    @PostMapping("/user")
    public String createUser(@RequestBody User user)
    {
           return service.createUser(user);
    }


    //API which will read data from database.
    @GetMapping("/user")
    public User findUser(@RequestParam Long userID)
    {
        return service.findUser(userID);
    }


    //Update API
    @PutMapping("/user")
    public String updateUser(@RequestParam Long userID,@RequestBody User user)
    {
        return service.updateUser(userID,user);
    }


    //API which will delete data in the user table.
    @DeleteMapping("/user")
    public String deleteUser(@RequestParam Long userID)
    {
        return service.deleteUser(userID);
    }

}
