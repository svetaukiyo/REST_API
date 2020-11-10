package com.svetaukiyo.restApi.service.impl;

import com.svetaukiyo.restApi.dto.ArtistDto;
import com.svetaukiyo.restApi.dto.mapper.CustomConverter;
import com.svetaukiyo.restApi.model.Artist;
import com.svetaukiyo.restApi.model.PageArtist;
import com.svetaukiyo.restApi.repository.ArtistRepository;
import com.svetaukiyo.restApi.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ArtistServiceImpl implements ArtistService {

    private ArtistRepository artistRepository;
    private CustomConverter customConverter;

    @Autowired
    public ArtistServiceImpl(ArtistRepository artistRepository, CustomConverter customConverter) {
        this.artistRepository = artistRepository;
        this.customConverter = customConverter;
    }

    @Override
    public PageArtist getAll(Pageable pageable) {
        PageArtist pageArtist = new PageArtist();
        pageArtist.setPages(getPages(pageable));
        pageArtist.setArtists(artistRepository.findAll(pageable)
                .getContent()
                .stream()
                .map(artist -> customConverter.convertToDto(artist, ArtistDto.class))
                .collect(Collectors.toList()));
        return pageArtist;
    }

    @Override
    public Artist update(Artist artist) {
        return artistRepository.save(artist);
    }

    private int getPages(Pageable pageable) {
        return (int) Math.ceil((double) artistRepository.count() / pageable.getPageSize());
    }
}
