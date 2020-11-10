package com.svetaukiyo.restApi.repository;

import com.svetaukiyo.restApi.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    Optional<Artist> findByUsernameOrEmail(String username, String email);
}
