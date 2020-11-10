package com.svetaukiyo.restApi.model;

import com.svetaukiyo.restApi.dto.SongDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PageSong {
    private int pages;
    private List<SongDto> playlists;
}
