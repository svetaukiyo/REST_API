package com.svetaukiyo.restApi.repository;

import com.svetaukiyo.restApi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUsername(String username);

    Optional<Account> findByUsernameAndPassword(String username, String password);

    Optional<Account> findAccountByArtistId(Long id);

    Optional<Account> findAccountByFollowerId(Long id);
}
