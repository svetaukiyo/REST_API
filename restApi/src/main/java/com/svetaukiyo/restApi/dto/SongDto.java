package com.svetaukiyo.restApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {

    private Long id;

    private String songName;

    private PlaylistDto playlist;
}
