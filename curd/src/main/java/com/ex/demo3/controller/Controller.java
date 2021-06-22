package com.ex.demo3.controller;

import com.ex.demo3.history.count;
import com.ex.demo3.mysql.customer;
import com.ex.demo3.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller
{

    @Autowired
     ServiceLayer service;

    //creating a get mapping that retrieves all the customer detail from the database
    @GetMapping("/customer")
    private List<customer> getAllCustomers() {
        return service.getAllCustomers();
    }
    
    @GetMapping("/customer/name/{name}")
    public customer findByName(@PathVariable String name)
    {
        return service.findByName(name);
    }
    @GetMapping("/customquery")
    List<String>CustomQuery()
    {
        return service.CustomQuery();
    }

    @GetMapping("/customer/age/{age}")
    public customer findByAge(@PathVariable int age)
    {
        return service.findByAge(age);

    }
    @GetMapping("/setage")
    void SetAge()
    {
        service.SetAge();

    }

    //creating a get mapping to find history of operations done.
    @GetMapping("/customer/history")
    public List<count>getHistory()
    {
        return service.getHistory();
    }


   //creating a get mapping that retrieves the detail of a specific customer
    @GetMapping("/customer/{customerid}")
    private customer getCustomer(@PathVariable("customerid") int customerid)
    {
        return service.getCustomerbyId(customerid);
    }
    //creating a delete mapping that deletes a specified customer
    @DeleteMapping("/customer/{customerid}")
    private void deleteCustomer(@PathVariable("customerid") int customerid)
    {
        service.deleteCustomer(customerid);
    }
    //creating post mapping that post the customer detail in the database
    @PostMapping("/customer")
    private String saveCustomer(@RequestBody customer customer)
    {
        service.saveOrUpdate(customer);
        return customer.getName();
    }
    //creating put mapping that updates the customer detail
    @PutMapping("/customer")
    private customer updateCustomer(@RequestBody customer customer)
    {
        service.saveOrUpdate(customer);
        return customer;
    }

    //Ignore commented part.

/*
@RestController
public class Controller {


  // @RequestMapping(path = "/hello/{id}", method = RequestMethod.GET)
    @Autowired
    public ServiceLayer services;
    @GetMapping("/hello/{id}")
   public int getBook(@PathVariable int id) {
       // code here
      return services.getresult(id);


   }*/
    /*
   @RequestMapping(method = RequestMethod.GET, value = "/hello")
   public String controllerMethod(@RequestParam int id) {
     String s="";
     for(int i=0;i<10;i++)
         s+=(i*id)+" ";

     return s;
   }
   /*
     */
  /*
   @RequestMapping(method = RequestMethod.GET, value = "/hello")
   public String controllerMethod(@RequestParam Map<String,String> customQuery) {

       System.out.println("customQuery = brand " + customQuery.containsKey("brand"));
       System.out.println("customQuery = limit " + customQuery.containsKey("limit"));
       System.out.println("customQuery = price " + customQuery.containsKey("price"));
       System.out.println("customQuery = other " + customQuery.containsKey("other"));
       System.out.println("customQuery = sort " + customQuery.containsKey("sort"));

       return customQuery.toString();
   }
   */

        public int  getmessage()
    {
         System.out.println("Hi you are you there");
         return 3;
    }
    public String putmessage()
    {
        return "Hi you are in put";
    }
}
