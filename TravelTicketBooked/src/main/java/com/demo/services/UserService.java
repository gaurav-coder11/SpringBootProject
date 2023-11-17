package com.demo.services;

import com.demo.entity.User;

public interface UserService {
    User saveUser(User user);
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);
    // Other methods as needed
	User findByEmail(String email);
}
