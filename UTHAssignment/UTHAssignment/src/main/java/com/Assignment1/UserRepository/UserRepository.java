package com.Assignment1.UserRepository;

import com.Assignment1.User.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends CrudRepository<User,Long > {

    public User findByUserName(String userName);

    public User findByEmailID(String emailID);

    public User findByMobileNumber(String mobileNumber);

    public User findByUserID(Long userID);

}
