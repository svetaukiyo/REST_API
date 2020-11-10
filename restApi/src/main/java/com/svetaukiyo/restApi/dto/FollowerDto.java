package com.svetaukiyo.restApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FollowerDto {

    private Long id;

    private String username;

    private String email;

    private String address;
}
