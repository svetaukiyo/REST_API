package com.svetaukiyo.restApi.service.impl;

import com.svetaukiyo.restApi.model.Follower;
import com.svetaukiyo.restApi.repository.FollowerRepository;
import com.svetaukiyo.restApi.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerServiceImpl implements FollowerService {

    private FollowerRepository followerRepository;

    @Autowired
    public FollowerServiceImpl(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }

    @Override
    public List<Follower> getAll() {
        return followerRepository.findAll();
    }

    @Override
    public Follower update(Follower follower) {
        return followerRepository.save(follower);
    }
}
