package com.svetaukiyo.restApi.controller;

import com.svetaukiyo.restApi.dto.ArtistDto;
import com.svetaukiyo.restApi.dto.mapper.CustomConverter;
import com.svetaukiyo.restApi.model.Artist;
import com.svetaukiyo.restApi.model.PageArtist;
import com.svetaukiyo.restApi.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    private static final int PAGE_SIZE = 4;
    private ArtistService artistService;
    private CustomConverter customConverter;

    @Autowired
    public ArtistController(ArtistService artistService, CustomConverter customConverter) {
        this.artistService = artistService;
        this.customConverter = customConverter;
    }

    @GetMapping("/all")
    public PageArtist getAll(@PageableDefault(sort = {"username"},
            direction = Sort.Direction.ASC,
            size = PAGE_SIZE) Pageable pageable) {
        return artistService.getAll(pageable);
    }

    @PostMapping("/update")
    public ArtistDto update(@Validated @RequestBody Artist artist) {
        return customConverter.convertToDto(artistService.update(artist), ArtistDto.class);
    }
}
