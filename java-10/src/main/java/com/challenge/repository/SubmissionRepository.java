package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SubmissionRepository extends CrudRepository<Submission, Long> {

    @Query("select max(s.score) from Submission s where s.id.challenge.id = :id")
    BigDecimal findHigherScoreByChallengeId(@Param("id") Long challengeId);


    @Query("select s from Submission s, Acceleration a where s.id.challenge.id = :challengeId and a.id = :accelerationId")
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId,@Param("accelerationId") Long accelerationId);
}
