package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SubmissionRepository extends CrudRepository<Submission, Long> {

    BigDecimal findHigherScoreByChallengeId(Long challengeId);

    List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);
}
