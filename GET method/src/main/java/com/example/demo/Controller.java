package com.example.demo;


import com.example.demo.Service.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
public class Controller {


    @Autowired
    service service;

   // @RequestMapping(value = "/", method = GET)
    @GetMapping("/sqrt/{num}")
    public String result(@PathVariable Double num)
    {
 /*       String res="";
        for(int i=0;i<=id;i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print("*");
                res+="*";
            }
            System.out.print("\n");
            res+="\n";
        }
        return res;*/

     //   String id=PathMap.get("id");
     //   String name=PathMap.get("name");
        /*if(id==null)
            return "No id present";
        return "id is :"+id+"\nname is :";*/
        if(num==null)
            return "No input given";
        else
            return service.squareRoot(num);

    }
    @GetMapping("/history")
    HashSet<Double> getHistory()
    {
        return service.getHistory();
    }

}
