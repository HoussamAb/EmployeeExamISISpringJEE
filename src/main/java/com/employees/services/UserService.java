package com.employees.services;

import com.employees.entities.Departement;
import com.employees.entities.User;
import com.employees.exceptions.ResourceNotFoundException;

import java.util.List;

public interface UserService{

    public List<User> getAllUser();

    User findById(long id) throws ResourceNotFoundException;

    void save(User user);

    void deleteById(long id);

    User findByEmailAndPassword(String username,String password);

}
