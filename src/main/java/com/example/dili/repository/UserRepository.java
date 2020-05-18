package com.example.dili.repository;

import com.example.dili.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query(value = "select * from User where Email=?1", nativeQuery = true)
    User findUserByEmail(String email);
}
