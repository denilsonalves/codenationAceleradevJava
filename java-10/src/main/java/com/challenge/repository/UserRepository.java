package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select c.id.user from Candidate c where c.id.acceleration.id = (select a.id from Acceleration a where a.name like :name)")
    List<User> findByAccelerationName(@Param("name") String name);


    @Query("select c.id.user from Candidate c where c.id.company.id = :id")
    List<User> findByCompanyId(@Param("id") Long id);
}
