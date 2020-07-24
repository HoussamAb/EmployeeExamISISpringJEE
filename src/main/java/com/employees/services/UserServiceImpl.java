package com.employees.services;

import com.employees.entities.User;
import com.employees.exceptions.ResourceNotFoundException;
import com.employees.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        List<User> all = userRepository.findAll();
        return all;
    }

    @Override
    @Transactional
    public User findById(long id) throws ResourceNotFoundException {
        return userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException(id)
        );
    }

    @Override
    @Transactional
    public void save(User user) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        user.setCreated(timestamp);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByEmailAndPassword(String username, String password) {
        return userRepository.findByEmailAndPassword(username,password);
    }

}
