package com.svetaukiyo.restApi.service;

import com.svetaukiyo.restApi.model.Artist;

import java.util.List;

public interface ArtistService {

    List<Artist> getAll();

    Artist update(Artist artist);
}
