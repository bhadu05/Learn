package com.Assignment1.Models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table
@DynamicUpdate
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  userID;
    @Column(unique = true)
    private String userName;

    private String firstName;

    private String lastName;
    @Column(unique = true)
    private String mobileNumber;
    @Column(unique = true)
    private String emailID;

    private String address1;

    private String address2;




    public User() {
    }



    public Long getUserID() {
        return userID;
    }

    public User( String userName, String firstName, String lastName, String mobileNumber, String emailID, String address1, String address2) {

        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.emailID = emailID;
        this.address1 = address1;
        this.address2 = address2;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }
}
