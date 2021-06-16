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
        count obj = new count();
        obj.setCount(historyRepository.findByName("Get"));
        historyRepository.save()
        return customer;
    }
    //getting a specific record by using the method findById() of CrudRepository
    public customer getCustomerbyId(int id)
    {
        return customerRepository.findById(id).get();
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(customer customer)
    {
        customerRepository.save(customer);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void deleteCustomer(int id)
    {
        customerRepository.deleteById(id);
    }
    //updating a record
    public void updatecustomer(customer customer, int bookid)
    {
        customerRepository.save(customer);
    }
    public List<count> getHistory()
    {
        List<count> count = new ArrayList<count>();
        historyRepository.findAll().forEach(count1 -> count.add(count1));
        return count;
    }
}
