package com.tekarch.flight.TafUserService.Service.Interface;

import com.tekarch.flight.TafUserService.Model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();

    User updateUser(Long id, User user);

    void deleteUser(Long id);
}