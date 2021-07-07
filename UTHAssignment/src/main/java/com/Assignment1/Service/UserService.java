package com.Assignment1.Service;

import com.Assignment1.Models.User;
import com.Assignment1.Models.UserWallet;
import com.Assignment1.Repositories.PaginationRepository;
import com.Assignment1.Repositories.TransactionRepository;
import com.Assignment1.Repositories.UserRepository;
import com.Assignment1.Repositories.UserWalletRepository;
import com.Assignment1.Models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserWalletRepository userWalletRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    PaginationRepository paginationRepository;

/*    //Method to check if a user already exist in database.
    public boolean ifUserExist(User user)
    {
        //return true if found same userName, emailID or mobileNumber.
        //Database level constraint. using unique key.
        return (userRepository.findByUserName(user.getUserName())!=null || userRepository.findByEmailID(user.getEmailID())!=null || userRepository.findByMobileNumber(user.getMobileNumber())!=null);
    }*/



    //Method to create a new user.
    public User createUser(User user) {



            //If valid than add the user to database and return the userID.
           return  userRepository.save(user);
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


                //Add the given userId to user.
                //So that save method will update previous user and not create a new user.
                user.setUserID(userID);

                //Update the user.
                userRepository.save(user);
                return "User updated successfully.";

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
