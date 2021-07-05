package com.Assignment1.Models;

import com.Assignment1.Models.User;

import javax.persistence.*;

@Entity
@Table(name = "wallet")
public class UserWallet {

    @Id
    @Column(unique = true)
    String mobileNumber;
    @Column
    Double balance;

    public UserWallet() {
        this.balance = 0.0;
    }
    public UserWallet(String mobileNumber)
    {
        this.mobileNumber=mobileNumber;
        this.balance=1000.0;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double amount) {
        this.balance = amount;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        if(mobileNumber.equals(((UserWallet)obj).mobileNumber) && balance.equals(((UserWallet)obj).balance))
            return true;
        return false;
    }
}
