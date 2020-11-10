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
public class ArtistDto {
    private Long id;

    private String username;

    private String photo;

    private String email;

    private String alias;

    private String address;

    private List<SongDto> songs;
}
