package com.svetaukiyo.restApi.controller;

import com.svetaukiyo.restApi.dto.FollowerDto;
import com.svetaukiyo.restApi.dto.mapper.CustomConverter;
import com.svetaukiyo.restApi.model.Follower;
import com.svetaukiyo.restApi.model.PageFollower;
import com.svetaukiyo.restApi.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/follower")
public class FollowerController {

    private static final int PAGE_SIZE = 4;
    private FollowerService followerService;
    private CustomConverter customConverter;

    @Autowired
    public FollowerController(FollowerService followerService, CustomConverter customConverter) {
        this.followerService = followerService;
        this.customConverter = customConverter;
    }

    @GetMapping("/all")
    public PageFollower getAll(@PageableDefault(sort = {"username"},
            direction = Sort.Direction.ASC,
            size = PAGE_SIZE) Pageable pageable) {
        return followerService.getAll(pageable);
    }

    @PostMapping("/update")
    public FollowerDto update(@Validated @RequestBody Follower follower) {
        return customConverter.convertToDto(followerService.update(follower), FollowerDto.class);
    }
}
