package com.challenge.service.impl;

import com.challenge.entity.Challenge;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallangeServiceImpl implements ChallengeServiceInterface {
    @Override
    public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
        return null;
    }

    @Override
    public Challenge save(Challenge object) {
        return null;
    }
}
