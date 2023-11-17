package com.demo.services;

import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.exceptions.UserNotFoundException;
import com.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long userId, User user) {
        User existingUser = userRepository.findById(userId).orElseThrow(() -> 
        new UserNotFoundException(userId));

        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

    // Other implementations for service methods
}

