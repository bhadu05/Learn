package com.ex.demo3.mysql;
import org.springframework.data.repository.CrudRepository;

public interface customerRepository extends CrudRepository<customer, Integer> {
  
       public customer findByName(String Name);
     public customer findByAge(int age);
     @Query(
             value = "SELECT name FROM customer",
             nativeQuery = true)
     List<String> CustomQuery();

     @Modifying
     @Transactional
     @Query(value="UPDATE customer c SET c.age=56 WHERE c.age=24",nativeQuery = true)
     void SetAge();


}
