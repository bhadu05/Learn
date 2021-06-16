package com.example.demo.Service;

import org.springframework.stereotype.Service;

import java.util.HashSet;

import static java.lang.StrictMath.sqrt;
@Service
public class service {

    HashSet<Double>set = new HashSet<Double>();
    public String squareRoot(Double num) {
        set.add(num);
        return Double.toString(sqrt(num));
    }
    public HashSet<Double> getHistory()
    {
        return set;
    }

}