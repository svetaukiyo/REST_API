package com.svetaukiyo.restApi.service.impl;

import com.svetaukiyo.restApi.model.Artist;
import com.svetaukiyo.restApi.repository.ArtistRepository;
import com.svetaukiyo.restApi.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private ArtistRepository artistRepository;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    @Override
    public Artist update(Artist artist) {
        return artistRepository.save(artist);
    }
}
