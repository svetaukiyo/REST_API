package com.svetaukiyo.restApi.service;

import com.svetaukiyo.restApi.model.Follower;

import java.util.List;

public interface FollowerService {

    List<Follower> getAll();

    Follower update(Follower follower);
}
