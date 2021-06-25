package com.Assignment1.Service;

import com.Assignment1.User.User;
import com.Assignment1.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class service {

    @Autowired
    UserRepository userRepository;

    //Method to check if a user already exist in database.
    public boolean ifUserExist(User user)
    {
        //return true if found same userName, emailID or mobileNumber.
        return (userRepository.findByUserName(user.getUserName())!=null || userRepository.findByEmailID(user.getEmailID())!=null || userRepository.findByMobileNumber(user.getMobileNumber())!=null);
    }



    //Method to create a new user.
    public String createUser(User user) {

        //Check for validations.

        if(ifUserExist(user))
        {
            return "User already exist.";
        }
        else
        {
            //If valid than add the user to database and return the userID.
           return  "UserId is: "+userRepository.save(user).getUserID();
        }
    }



    //Method to find user using userID.
    public User findUser(Long userID)
    {

          return userRepository.findByUserID(userID);
    }



    //Method to update a user using userID.
    public String updateUser(Long userID,User user)
    {

        //Check for validations.
        //Check if user with given userID exist or not.
        if(userRepository.findByUserID(userID)==null)
        {
            return "User does not exist.";
        }
        else
        {
            //If user exist with given userID.
            //Check if updated user already present in database or not.
            if(ifUserExist(user))
            {
                return "User already exist with same details.";
            }
            else
            {

                //Add the given userId to user.
                //So that save method will update previous user and not create a new user.
                user.setUserID(userID);

                //Update the user.
                userRepository.save(user);
                return "User updated successfully.";
            }
        }
    }



    //Method to delete a user using userID.
    public String deleteUser(Long userID) {

        //Check for validations.
        //Check if user with given userID present in database or not.
        if(userRepository.findByUserID(userID)==null)
        {
            return "User does not exist.";
        }
        else
        {
            //Delete the user with given userID.
            userRepository.deleteById(userID);
            return "User deleted successfully.";
        }
    }
}
