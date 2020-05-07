package com.challenge.repository;


import com.challenge.entity.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long> {

    Optional<Company> findById(Long id);

    List<Company> findByAccelerationId(Long accelerationId);

    List<Company> findByUserId(Long userId);
}
