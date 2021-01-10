package com.cloud.snow.repository;

import com.cloud.snow.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User,Integer> {

    @Query(value = "select u from User u where u.name like %?1%")
    List<User> findByName(String name);
}
