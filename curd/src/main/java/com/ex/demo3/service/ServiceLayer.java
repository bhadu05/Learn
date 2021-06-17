package com.ex.demo3.service;

import com.ex.demo3.history.count;
import com.ex.demo3.history.historyRepository;
import com.ex.demo3.mysql.customer;
import com.ex.demo3.mysql.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLayer
{
    @Autowired
    customerRepository customerRepository;
    @Autowired
    historyRepository historyRepository;
    //getting all customers record by using the method findaAll() of CrudRepository
    public List<customer> getAllCustomers()
    {
        List<customer> customer = new ArrayList<customer>();
        customerRepository.findAll().forEach(customer1 -> customer.add(customer1));

        //For history purpose
        //For history purpose.
        postHistory("GET");
        handleHistory();
        return customer;
    }
    //getting a specific record by using the method findById() of CrudRepository
    public customer getCustomerbyId(int id)
    {
        //For history purpose.
        postHistory("GET");
        handleHistory();
        
        
        return customerRepository.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(customer customer)
    {
        //For history purpose.
        postHistory("POST");
        handleHistory();
        
        
        customerRepository.save(customer);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void deleteCustomer(int id)
    {
        //For history purpose.
        postHistory("DELETE");
        handleHistory();
        
        
        customerRepository.deleteById(id);
    }
    //updating a record
    public void updatecustomer(customer customer, int bookid)
    {
        customerRepository.save(customer);
        
        //For history purpose.
        postHistory("PUT");
        handleHistory();
    }
    public List<count> getHistory()
    {
        List<count> count = new ArrayList<count>();
        historyRepository.findAll().forEach(count1 -> count.add(count1));
        return count;
    }
    //To keep track of history.
    public void postHistory(String type)
    {
        List<count> all = new ArrayList<>();
        boolean get=false;
        boolean post=false;
        boolean put=false;
        boolean delete=false;
        historyRepository.findAll().forEach(count1->all.add(count1));
        for(count temp:all)
        {
            if(temp.getType()=="GET") {
                get = true;
            }
            if(temp.getType()=="POST") {
                post = true;
            }
            if(temp.getType()=="PUT") {
                put = true;
            }
            if(temp.getType()=="DELETE") {
                delete = true;
            }
        }
        count obj = new count();
        switch (type)
        {

            case "GET":
                if(!get)
                {
                    obj.setType("GET");
                    historyRepository.save(obj);
                }
                break;
            case "POST":
                if(!post)
                {
                    obj.setType("POST");
                    historyRepository.save(obj);
                }
                break;

            case "PUT":
                if(!put)
                {
                    obj.setType("Put");
                    historyRepository.save(obj);
                }
                break;
            case "DELETE":
                if(!delete)
                {
                    obj.setType("DELETE");
                    historyRepository.save(obj);
                }
                break;
        }


    }
    public void handleHistory()
    {
        List<count> all = new ArrayList<>();
        historyRepository.findAll().forEach(count1->all.add(count1));
        for(count temp:all)
        {
            if(temp.getType()=="GET")
            {
                temp.setCount(temp.getCount()+1);
            }
            else if (temp.getType()=="POST")
            {
                temp.setCount(temp.getCount()+1);
            }
            else if (temp.getType()=="PUT")
            {
                temp.setCount(temp.getCount()+1);
            }
            else if (temp.getType()=="DELETE")
            {
                temp.setCount(temp.getCount()+1);
            }
        }

    }
}
