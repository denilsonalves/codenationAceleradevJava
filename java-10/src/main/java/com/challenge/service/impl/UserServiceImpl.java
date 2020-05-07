package com.challenge.service.impl;

import com.challenge.entity.Acceleration;
import com.challenge.entity.User;
import com.challenge.repository.AccelerationRepository;
import com.challenge.repository.CompanyRepository;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccelerationRepository accelerationRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Optional<User> findById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            return user;
        }
        return null;
    }

    @Override
    public List<User> findByAccelerationName(String name) {
        Acceleration acceleration = accelerationRepository.findByName(name);
        List<User> users = accelerationRepository.findUserById(acceleration.getId());
        return users;
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {
        return null;
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }
}
