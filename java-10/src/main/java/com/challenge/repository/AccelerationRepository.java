package com.challenge.repository;

import com.challenge.entity.Acceleration;
import com.challenge.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

    Optional<Acceleration> findById(Long id);

    List<Acceleration> findByCompanyId(Long companyId);

    Acceleration findByName(String name);

    List<User> findUserById(Long id);
    
}

