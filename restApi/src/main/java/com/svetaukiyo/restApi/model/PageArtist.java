package com.svetaukiyo.restApi.model;

import com.svetaukiyo.restApi.dto.ArtistDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageArtist {
    private int pages;
    private List<ArtistDto> artists;
}
