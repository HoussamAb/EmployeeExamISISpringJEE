package com.employees.repositories;

import com.employees.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
    @Query("from User u where u.email=:email and u.password=:password")
    User findByEmailAndPassword(@Param("email")String email,@Param("password") String password);

}
