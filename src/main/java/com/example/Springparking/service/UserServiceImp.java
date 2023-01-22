package com.example.Springparking.service;

import com.example.Springparking.entity.User;
import com.example.Springparking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) throws Exception {
        user = userRepository.save(user);
        return user;
    }
    @Override
    public User getUserByid(Long id) throws Exception{
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("User does not exist"));
        return user;
    }


    @Override
    public User updateUser(User fromUser) throws Exception {
        User toUser = getUserByid(fromUser.getId());
        mapUser(fromUser, toUser);
        return userRepository.save(toUser);
    }


    protected void mapUser(User from, User to){
       to.setNombre(from.getNombre());
       to.setApellido(from.getApellido());
       to.setMail(from.getMail());
       to.setNombreUsuario(from.getNombreUsuario());
    }

    public void deleteUser(Long id) throws Exception{
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception("UsernotFound in deleteUser -"+this.getClass().getName()));

        userRepository.delete(user);
    }
}
