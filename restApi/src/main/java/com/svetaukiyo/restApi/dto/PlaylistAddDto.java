package com.svetaukiyo.restApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistAddDto {

    private Long id;

    private String playlistName;

    private ArtistDto artist;

    private FollowerDto follower;
}
