package com.svetaukiyo.restApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongAddDto {

    private Long id;

    private String songName;

    private PlaylistDto playlist;

    private List<ArtistDto> artists;
}
