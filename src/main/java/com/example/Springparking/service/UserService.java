package com.example.Springparking.service;

import com.example.Springparking.entity.User;

public interface UserService {
    public Iterable<User> getAllUsers();

    public User createUser(User user) throws Exception;
    public User getUserByid(Long id) throws Exception;

    public User updateUser(User user) throws Exception;
    public void deleteUser(Long id) throws Exception;
}
