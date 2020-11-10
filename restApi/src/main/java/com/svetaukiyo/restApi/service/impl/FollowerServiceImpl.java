package com.svetaukiyo.restApi.service.impl;

import com.svetaukiyo.restApi.dto.FollowerDto;
import com.svetaukiyo.restApi.dto.mapper.CustomConverter;
import com.svetaukiyo.restApi.model.Follower;
import com.svetaukiyo.restApi.model.PageFollower;
import com.svetaukiyo.restApi.repository.FollowerRepository;
import com.svetaukiyo.restApi.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class FollowerServiceImpl implements FollowerService {

    private FollowerRepository followerRepository;
    private CustomConverter customConverter;

    @Autowired
    public FollowerServiceImpl(FollowerRepository followerRepository, CustomConverter customConverter) {
        this.followerRepository = followerRepository;
        this.customConverter = customConverter;
    }

    @Override
    public PageFollower getAll(Pageable pageable) {
        PageFollower pageFollower = new PageFollower();
        pageFollower.setPages(getPages(pageable));
        pageFollower.setFollowers(followerRepository.findAll(pageable)
                .getContent()
                .stream()
                .map(follower -> customConverter.convertToDto(follower, FollowerDto.class))
                .collect(Collectors.toList()));
        return pageFollower;
    }

    @Override
    public Follower update(Follower follower) {
        return followerRepository.save(follower);
    }

    private int getPages(Pageable pageable) {
        return (int) Math.ceil((double) followerRepository.count() / pageable.getPageSize());
    }
}
