package com.svetaukiyo.restApi.service.impl;

import com.svetaukiyo.restApi.exception.InvalidLoginException;
import com.svetaukiyo.restApi.model.Account;
import com.svetaukiyo.restApi.model.Artist;
import com.svetaukiyo.restApi.model.Follower;
import com.svetaukiyo.restApi.model.RegistrationModel;
import com.svetaukiyo.restApi.repository.AccountRepository;
import com.svetaukiyo.restApi.repository.ArtistRepository;
import com.svetaukiyo.restApi.repository.FollowerRepository;
import com.svetaukiyo.restApi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final static String ROLE_ARTIST = "ARTIST";
    private final static String ROLE_FOLLOWER = "FOLLOWER";

    private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;
    private ArtistRepository artistRepository;
    private FollowerRepository followerRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,
                              PasswordEncoder passwordEncoder,
                              ArtistRepository artistRepository,
                              FollowerRepository followerRepository) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.artistRepository = artistRepository;
        this.followerRepository = followerRepository;
    }

    @Override
    public RegistrationModel register(RegistrationModel registrationModel) {
        setFieldsToAccount(registrationModel.getAccount());
        createUserByRole(registrationModel.getAccount(), registrationModel.getArtist(),
                registrationModel.getFollower());
        return registrationModel;
    }

    private void setFieldsToAccount(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setStatus(true);
        account.setActive(1);
    }

    private void createUserByRole(Account account, Artist artist, Follower follower) {
        if (artist != null) {
            registerArtist(account, artist);
        }
        else if (follower != null) {
            registerFollower(account, follower);
        }
    }

    private void registerArtist(Account account, Artist artist) {
        artistRepository.findByUsernameOrEmail(artist.getUsername(), artist.getEmail());
        account.setRole(ROLE_ARTIST);
        artist.setAccount(account);
        account.setArtist(artist);
        accountRepository.save(account);
        artistRepository.save(artist);
    }

    private void registerFollower(Account account, Follower follower) {
        followerRepository.findByUsernameOrEmail(follower.getUsername(), follower.getEmail());
        account.setRole(ROLE_FOLLOWER);
        follower.setAccount(account);
        account.setFollower(follower);
        accountRepository.save(account);
        followerRepository.save(follower);
    }

    @Override
    public Account login(Account account) {
        return accountRepository.findByUsernameAndPassword(account.getUsername(),
                account.getPassword()).orElseThrow(() ->
                new InvalidLoginException("invalid username or password", 405));
    }

    @Override
    public Account getAccountByArtist(Long id) {
        return accountRepository.findAccountByArtistId(id).get();
    }

    @Override
    public Account getAccountByFollower(Long id) {
        return accountRepository.findAccountByFollowerId(id).get();
    }
}
