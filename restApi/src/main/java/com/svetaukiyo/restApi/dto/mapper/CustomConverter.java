package com.svetaukiyo.restApi.dto.mapper;

import com.svetaukiyo.restApi.dto.AccountDto;
import com.svetaukiyo.restApi.dto.ArtistDto;
import com.svetaukiyo.restApi.dto.FollowerDto;
import com.svetaukiyo.restApi.dto.RegistrationModelDto;
import com.svetaukiyo.restApi.model.Account;
import com.svetaukiyo.restApi.model.RegistrationModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public CustomConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <D> D convertToDto(Object source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    public <D> D convertToEntity(Object source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    public AccountDto convertToDto(Account account) {
        AccountDto accountDto = modelMapper.map(account, AccountDto.class);
        if (account.getArtist() != null) {
            accountDto.setArtist_id(account.getArtist().getId());
        }
        else if (account.getFollower() != null) {
            accountDto.setFollower_id(account.getFollower().getId());
        }
        return accountDto;
    }

    public RegistrationModelDto convertToDto(RegistrationModel registrationModel) {
        RegistrationModelDto registrationModelDto = new RegistrationModelDto();
        registrationModelDto.setAccountDto(convertToDto(registrationModel.getAccount()));
        if (registrationModel.getFollower() != null)
            registrationModelDto.setFollowerDto(convertToDto(registrationModel.getFollower(), FollowerDto.class));
        else if (registrationModel.getArtist() != null)
            registrationModelDto.setArtistDto(convertToDto(registrationModel.getArtist(), ArtistDto.class));
        return registrationModelDto;
    }
}
