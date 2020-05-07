package com.challenge.repository;

import com.challenge.entity.Acceleration;
import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

    Optional<Acceleration> findById(Long id);

    @Query("select c.id.acceleration from Candidate c where c.id.company.id = :id")
    List<Acceleration> findByCompanyId(@Param("id") Long companyId);

    Acceleration findByName(String name);

    
}

