package com.svetaukiyo.restApi.controller;

import com.svetaukiyo.restApi.dto.ArtistDto;
import com.svetaukiyo.restApi.dto.mapper.CustomConverter;
import com.svetaukiyo.restApi.model.Artist;
import com.svetaukiyo.restApi.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    private ArtistService artistService;
    private CustomConverter customConverter;

    @Autowired
    public ArtistController(ArtistService artistService, CustomConverter customConverter) {
        this.artistService = artistService;
        this.customConverter = customConverter;
    }

    @GetMapping("/all")
    public List<Artist> getAll() {
        return artistService.getAll();
    }

    @PostMapping("/update")
    public ArtistDto update(@Validated @RequestBody Artist artist) {
        return customConverter.convertToDto(artistService.update(artist), ArtistDto.class);
    }
}
