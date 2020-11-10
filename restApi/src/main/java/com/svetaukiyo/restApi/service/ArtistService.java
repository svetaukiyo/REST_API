package com.svetaukiyo.restApi.service;

import com.svetaukiyo.restApi.model.Artist;
import com.svetaukiyo.restApi.model.PageArtist;
import org.springframework.data.domain.Pageable;

public interface ArtistService {

    PageArtist getAll(Pageable pageable);

    Artist update(Artist artist);
}
