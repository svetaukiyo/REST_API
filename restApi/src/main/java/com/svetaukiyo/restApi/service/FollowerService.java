package com.svetaukiyo.restApi.service;

import com.svetaukiyo.restApi.model.Follower;
import com.svetaukiyo.restApi.model.PageFollower;
import org.springframework.data.domain.Pageable;

public interface FollowerService {

    PageFollower getAll(Pageable pageable);

    Follower update(Follower follower);
}
