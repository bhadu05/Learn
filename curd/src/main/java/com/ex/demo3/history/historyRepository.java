package com.ex.demo3.history;


import org.springframework.data.repository.CrudRepository;

public interface historyRepository extends CrudRepository<count,Integer> {
    count findByName(String name)
    {
        
    }
}
