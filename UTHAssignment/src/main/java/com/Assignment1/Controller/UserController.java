package com.Assignment1.Controller;

import com.Assignment1.ParamCheck.ParamCheck;
import com.Assignment1.Service.UserService;
import com.Assignment1.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;

@RestController
public class UserController {

    @Autowired
    UserService UserService;

    //API which will create a user in the table.
    @PostMapping("/user")
    public User createUser(@RequestBody User user)
    {
        try {

            ParamCheck.checkUser(user);
            return UserService.createUser(user);
        }
        catch (InvalidParameterException e)
        {
            throw new InvalidParameterException(e.getLocalizedMessage());
        }
/*            System.out.println(user.getAddress1());


        else
         throw new InvalidParameterException("Invalid Parameters in user");*/
    }


    //API which will read data from database.
    @GetMapping("/user")
    public User findUser(@RequestParam Long userID)
    {
        if(ParamCheck.checkUserID(userID))
        return UserService.findUser(userID);
        else
            throw new InvalidParameterException("Invalid Parameters");
    }


    //Update API
    @PutMapping("/user")
    public String updateUser(@RequestParam Long userID,@RequestBody User user)
    {
        if(ParamCheck.checkUserID(userID) && ParamCheck.checkUser(user))
        return UserService.updateUser(userID,user);
        else
            throw new InvalidParameterException("Invalid Parameters");

    }


    //API which will delete data in the user table.
    @DeleteMapping("/user")
    public String deleteUser(@RequestParam Long userID)
    {

        try {
                ParamCheck.checkUserID(userID);
                return UserService.deleteUser(userID);
        }
        catch (InvalidParameterException e) {
            throw new InvalidParameterException(e.getLocalizedMessage());
        }

    }


}
