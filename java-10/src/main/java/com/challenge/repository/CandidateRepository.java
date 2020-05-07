package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, Long> {

    @Query("select c from Candidate c where c.id.user.id = :userId and c.id.company.id = :companyId and c.id.acceleration.id = :accelerationId")
    Optional<Candidate> findById(@Param("userId") Long userId, @Param("companyId") Long companyId, @Param("accelerationId") Long accelerationId);


    @Query("select c from Candidate c where c.id.company.id = :id")
    List<Candidate> findByCompanyId(@Param("id") Long companyId);


    @Query("select c from Candidate c where c.id.acceleration.id = :id")
    List<Candidate> findByAccelerationId(@Param("id") Long accelerationId);

    Optional<Candidate> findById(CandidateId id);

    // @Query("select c from Candidate c where c.id.candidate.id = :id")
//    Optional<Candidate> findById(CandidateId id);
//
//    @Query("select c from Candidate c where c.id.user.id = :userId and c.id.company.id = : companyId and c.id.acceleration.id = :accelerationId")
//    Optional<Candidate> findById(@Param("userId") Long userId, @Param("companyId") Long companyId, @Param("accelerationId") Long accelerationId);
//
//    @Query("select c from Candidate c where c.id.company.id = :id")
//    List<Candidate> findByCompanyId(@Param("id") Long companyId);
//
//    @Query("select c from Candidate c where c.id.acceleration.id= :id")
//    List<Candidate> findByAccelerationId(@Param("id") Long accelerationId);
}
