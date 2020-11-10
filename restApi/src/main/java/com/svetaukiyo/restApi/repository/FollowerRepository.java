package com.svetaukiyo.restApi.repository;

import com.svetaukiyo.restApi.model.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FollowerRepository extends JpaRepository<Follower, Long> {

    Optional<Follower> findByUsernameOrEmail(String username, String email);
}
