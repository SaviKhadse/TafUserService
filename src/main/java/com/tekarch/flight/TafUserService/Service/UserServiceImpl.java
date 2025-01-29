package com.tekarch.flight.TafUserService.Service;

import com.tekarch.flight.TafUserService.Model.User;
import com.tekarch.flight.TafUserService.Service.Interface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

//    private static final String DATASTORE_BASE_URL = "http://localhost:8081/users";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${users.ms.url}")
    String usersurl;

    @Override
    public User createUser(User user) {
        return restTemplate.postForObject(usersurl, user, User.class);
    }

    @Override
    public User getUserById(Long id) {
        return restTemplate.getForObject(usersurl + "/" + id, User.class);
    }

    @Override
    public List<User> getAllUsers() {
        User[] users = restTemplate.getForObject(usersurl, User[].class);
        return Arrays.asList(users);
    }

    @Override
    public User updateUser(Long id, User user) {
        restTemplate.put(usersurl + "/" + id, user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        restTemplate.delete(usersurl + "/" + id);
    }
}