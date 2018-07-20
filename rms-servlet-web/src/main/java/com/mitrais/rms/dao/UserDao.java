package com.mitrais.rms.dao;

import com.mitrais.rms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository <User,Integer>{

    @Query("select u from User u where u.userName= ?1")
    User findByUserName(String userName);

}
