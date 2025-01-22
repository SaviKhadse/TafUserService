package com.tekarch.flight.TafUserService.Service;

import com.tekarch.flight.TafUserService.Model.User;
import com.tekarch.flight.TafUserService.Service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final String DATASTORE_BASE_URL = "http://18.188.81.176:8081/users";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User createUser(User user) {
        return restTemplate.postForObject(DATASTORE_BASE_URL, user, User.class);
    }

    @Override
    public User getUserById(Long id) {
        return restTemplate.getForObject(DATASTORE_BASE_URL + "/" + id, User.class);
    }

    @Override
    public List<User> getAllUsers() {
        User[] users = restTemplate.getForObject(DATASTORE_BASE_URL, User[].class);
        return Arrays.asList(users);
    }

    @Override
    public User updateUser(Long id, User user) {
        restTemplate.put(DATASTORE_BASE_URL + "/" + id, user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        restTemplate.delete(DATASTORE_BASE_URL + "/" + id);
    }
}