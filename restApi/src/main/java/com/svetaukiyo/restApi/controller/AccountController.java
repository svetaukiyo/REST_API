package com.svetaukiyo.restApi.controller;

import com.svetaukiyo.restApi.dto.AccountDto;
import com.svetaukiyo.restApi.dto.RegistrationModelDto;
import com.svetaukiyo.restApi.dto.mapper.CustomConverter;
import com.svetaukiyo.restApi.model.Account;
import com.svetaukiyo.restApi.model.RegistrationModel;
import com.svetaukiyo.restApi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private AccountService accountService;
    private CustomConverter customConverter;

    @Autowired
    public AccountController(AccountService accountService, CustomConverter customConverter) {
        this.accountService = accountService;
        this.customConverter = customConverter;
    }

    @PostMapping("/account/registration")
    public RegistrationModelDto registerAccount(@RequestBody RegistrationModel registrationModel) {
        return customConverter.convertToDto(accountService.register(registrationModel));
    }

    @RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET})
    public Account loginAccount(@RequestBody Account account) {
        return accountService.login(account);
    }

    @GetMapping("/account/artist")
    public AccountDto getAccountByArtist(@RequestParam Long id) {
        return customConverter.convertToDto(accountService.getAccountByArtist(id));
    }

    @GetMapping("/account/follower")
    public AccountDto getAccountByFollower(@RequestParam Long id) {
        return customConverter.convertToDto(accountService.getAccountByFollower(id));
    }
}
