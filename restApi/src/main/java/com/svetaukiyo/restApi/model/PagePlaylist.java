package com.svetaukiyo.restApi.model;

import com.svetaukiyo.restApi.dto.PlaylistDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PagePlaylist {
    private int pages;
    private List<PlaylistDto> playlists;
}
