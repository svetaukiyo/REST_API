package com.svetaukiyo.restApi.model;

import com.svetaukiyo.restApi.dto.FollowerDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageFollower {
    private int pages;
    private List<FollowerDto> followers;
}
