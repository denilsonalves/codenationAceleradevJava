package com.challenge.repository;


import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    Optional<Company> findById(Long id);

    @Query("select distinct c.id.company from Candidate c where c.id.acceleration.id = :id")
    List<Company> findByAccelerationId(@Param("id") Long accelerationId);

    @Query("select c.id.company from Candidate c where c.id.user.id = :id")
    List<Company> findByUserId(@Param("id") Long userId);
}
