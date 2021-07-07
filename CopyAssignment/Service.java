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
public class service {

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

    public UserWallet createWallet(String mobileNumber) {

        //Check for validations.
        if(userRepository.findByMobileNumber(mobileNumber)!=null && userWalletRepository.findByID(mobileNumber)==null)
            return userWalletRepository.save(new UserWallet(mobileNumber));
        else
            throw new InvalidParameterException("User not registered or already have a wallet");

    }

    public Transaction doTransaction(String payerNumber, String payeeNumber, Double amount) {

        //Check for validations.
        if(userWalletRepository.findByID(payerNumber)!=null && userWalletRepository.findByID(payeeNumber)!=null && userWalletRepository.findByID(payerNumber).getBalance()>=amount)
        {

            //Create a transaction.
            Transaction transaction = transactionRepository.save(new Transaction(payerNumber, payeeNumber, amount, "Success"));

            //Find payerWallet and payeeWallet.
            UserWallet payerWallet = userWalletRepository.findByID(payerNumber);
            UserWallet payeeWallet = userWalletRepository.findByID(payeeNumber);

            //Adjust the amount after transaction for payer and payee.
            payerWallet.setBalance(payerWallet.getBalance()-amount);
            payeeWallet.setBalance(payeeWallet.getBalance()+amount);

            //Save new details in payerWallet and payeeWallet.
            userWalletRepository.save(payerWallet);
            userWalletRepository.save(payeeWallet);
            return transaction;
        }
        else
        {
            transactionRepository.save(new Transaction(payerNumber, payeeNumber, amount, "Failed"));
            throw new InvalidParameterException("Transaction have some problem");
        }

    }


    public Page<Transaction> getTransactionSummary(Long userID)
    {

        User user = userRepository.findByUserID(userID);

        //Check for validations.
        if(user!=null && userWalletRepository.findByID(user.getMobileNumber())!=null)
        {
            Pageable firstPageWithOneElement = PageRequest.of(0, 15, Sort.by("Date").descending());
            Page<Transaction> transactions = paginationRepository.findByUserID(firstPageWithOneElement, user.getMobileNumber());
            return transactions;
        }
        else
            throw new InvalidParameterException("Either user not exist or user does not have a wallet");
    }

    public Transaction getTransactionStatus(String transactionID) {
        if(transactionRepository.findByID(transactionID)!=null)
            return transactionRepository.findByID(transactionID);
        else
            throw new InvalidParameterException("TransactionID does not exist");
    }
}
