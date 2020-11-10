package com.svetaukiyo.restApi.service;

import com.svetaukiyo.restApi.model.Account;
import com.svetaukiyo.restApi.model.RegistrationModel;

public interface AccountService {

    RegistrationModel register(RegistrationModel registrationModel);

    Account login(Account account);

    Account getAccountByArtist(Long id);

    Account getAccountByFollower(Long id);
}
