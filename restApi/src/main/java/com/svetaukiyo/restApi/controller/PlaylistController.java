package com.svetaukiyo.restApi.controller;

import com.svetaukiyo.restApi.dto.PlaylistAddDto;
import com.svetaukiyo.restApi.dto.SongDto;
import com.svetaukiyo.restApi.dto.mapper.CustomConverter;
import com.svetaukiyo.restApi.model.PagePlaylist;
import com.svetaukiyo.restApi.model.Playlist;
import com.svetaukiyo.restApi.service.PlaylistService;
import com.svetaukiyo.restApi.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    private static final int PAGE_SIZE = 4;
    private PlaylistService playlistService;
    private CustomConverter customConverter;
    private SongService songService;

    @Autowired
    public PlaylistController(PlaylistService playlistService, CustomConverter customConverter, SongService songService) {
        this.playlistService = playlistService;
        this.customConverter = customConverter;
        this.songService = songService;
    }

    @GetMapping("/all")
    public PagePlaylist getAll(@PageableDefault(sort = {"playlistName"},
            direction = Sort.Direction.ASC,
            size = PAGE_SIZE) Pageable pageable) {
        return playlistService.getAll(pageable);
    }

    @GetMapping("/byFollower")
    public List<Playlist> getByFollowerId(@RequestParam Long id) {
        return playlistService.findAllByFollowerId(id);
    }

    @GetMapping("/byArtist")
    public PagePlaylist getByArtist(@RequestParam Long id,
                                    @PageableDefault(sort = {"playlistName"},
                                            direction = Sort.Direction.ASC,
                                            size = PAGE_SIZE) Pageable pageable) {
        return playlistService.findAllByArtistId(id, pageable);
    }

    @PostMapping("/add")
    public PlaylistAddDto addPlaylist(@Validated @RequestBody Playlist playlist) {
        return customConverter.convertToDto(playlistService.add(playlist), PlaylistAddDto.class);
    }

    @PostMapping("/update")
    public PlaylistAddDto updatePlaylist(@Validated @RequestBody Playlist playlist) {
        return customConverter.convertToDto(playlistService.update(playlist), PlaylistAddDto.class);
    }

    @PostMapping("/delete")
    public boolean delete(@RequestBody Long id) {
        playlistService.delete(id);
        return true;
    }
}
