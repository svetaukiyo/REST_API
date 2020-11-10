package com.svetaukiyo.restApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private Long id;

    private String username;

    private Boolean status;

    private Integer active;

    private String role;

    private Long follower_id;

    private Long artist_id;
}
