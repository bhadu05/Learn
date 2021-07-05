package com.Assignment1.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table
public class Transaction {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
   private String transactionID;
   private String payerNumber;
   private String payeeNumber;
   private Double amount;
   private String status;
   private String Date;

    public Transaction( String payerNumber, String payeeNumber, Double amount, String status) {
        this.payerNumber = payerNumber;
        this.payeeNumber = payeeNumber;
        this.amount = amount;
        this.status = status;
        Date date = new Date();
        String strDateFormat = "hh:mm:ss a";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        this.Date= dateFormat.format(date);
    }
    public Transaction()
    {

    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getPayerNumber() {
        return payerNumber;
    }

    public void setPayerNumber(String payerNumber) {
        this.payerNumber = payerNumber;
    }

    public String getPayeeNumber() {
        return payeeNumber;
    }

    public void setPayeeNumber(String payeeNumber) {
        this.payeeNumber = payeeNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object t) {
        if((Transaction)t==null)
            return false;
        if(amount.equals(((Transaction)t).amount) && payeeNumber.equals(((Transaction)t).payeeNumber) && payerNumber.equals(((Transaction)t).payerNumber) && status.equals(((Transaction)t).status))
            return true;
        return false;
    }

}