package com.svetaukiyo.restApi.controller;

import com.svetaukiyo.restApi.dto.FollowerDto;
import com.svetaukiyo.restApi.dto.mapper.CustomConverter;
import com.svetaukiyo.restApi.model.Follower;
import com.svetaukiyo.restApi.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follower")
public class FollowerController {

    private FollowerService followerService;
    private CustomConverter customConverter;

    @Autowired
    public FollowerController(FollowerService followerService, CustomConverter customConverter) {
        this.followerService = followerService;
        this.customConverter = customConverter;
    }

    @GetMapping("/all")
    public List<Follower> getAll() {
        return followerService.getAll();
    }

    @PostMapping("/update")
    public FollowerDto update(@Validated @RequestBody Follower follower) {
        return customConverter.convertToDto(followerService.update(follower), FollowerDto.class);
    }
}
