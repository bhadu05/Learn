package com.Assignment1.ParamCheck;
import com.Assignment1.Models.User;

import java.awt.print.Pageable;

public class ParamCheck {
    public static boolean checkMobileNumber(String mobileNumber)
    {

        if(mobileNumber.matches("^[0-9]{10}$") && (mobileNumber.charAt(0)!='0'))
            return true;
        System.out.println("Invalid mobileNumber");
        return false;



    }


   public static boolean checkFirstName(String firstName)
    {
        if((firstName != null) &&(!firstName.equals("")) && (firstName.matches("^[a-zA-Z]*$")))
            return true;
        System.out.println("Invalid firstName");
        return false;
    }


   public static boolean checkLastName(String lastName)
    {
        if((lastName == null) || (lastName.matches("^[a-zA-Z]*$")))
            return true;
        System.out.println("Invalid lastName");
        return false;
    }


    public static boolean checkBalance(Double balance)
    {
        if(balance<=0)
            return false;
        return true;
    }


    public static boolean checkUserID(Long userID)
    {
        return userID!=null;
    }


    public static boolean checkEmailID(String emailID)
    {
        if((emailID!=null) && (!emailID.equals("")) && (emailID.matches("^[a-zA-z0-9+._-]+@[a-zA-z+.]+[.][a-zA-z+.]+[a-zA-Z]+$")))
            return true;
        System.out.println("Invalid emailID");
        return false;
    }


    public static boolean checkUserName(String userName)
    {
        if(userName!=null && userName!="")
            return true;
        System.out.println("Invalid userName");
        return false;
    }

    public static boolean checkTransactionID(String transactionID)
    {
        if(transactionID!=null && transactionID!="")
            return true;
        System.out.println("Invalid transactionID");
        return false;
    }
    public static boolean checkUser(User user)
    {
         if(checkUserName(user.getUserName()) && checkFirstName(user.getFirstName()) && checkLastName(user.getLastName()) && checkMobileNumber(user.getMobileNumber()) && checkEmailID(user.getEmailID()) && (user.getAddress1()!=null))
             return true;
         return false;

    }
}
