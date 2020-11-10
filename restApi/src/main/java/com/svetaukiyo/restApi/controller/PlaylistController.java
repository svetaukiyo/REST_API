package com.svetaukiyo.restApi.controller;

import com.svetaukiyo.restApi.dto.PlaylistAddDto;
import com.svetaukiyo.restApi.dto.mapper.CustomConverter;
import com.svetaukiyo.restApi.model.PagePlaylist;
import com.svetaukiyo.restApi.model.Playlist;
import com.svetaukiyo.restApi.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    private static final int PAGE_SIZE = 4;
    private PlaylistService playlistService;
    private CustomConverter customConverter;

    @Autowired
    public PlaylistController(PlaylistService playlistService, CustomConverter customConverter) {
        this.playlistService = playlistService;
        this.customConverter = customConverter;
    }

    @GetMapping("/all")
    public PagePlaylist getAll(@PageableDefault(sort = {"playlistName"},
            direction = Sort.Direction.ASC,
            size = PAGE_SIZE) Pageable pageable) {
        return playlistService.getAll(pageable);
    }

    @GetMapping("/byFollower")
    public PagePlaylist getByFollower(@RequestParam Long id,
                                    @PageableDefault(sort = {"playlistName"},
                                            direction = Sort.Direction.ASC,
                                            size = PAGE_SIZE) Pageable pageable) {
        return playlistService.findAllByFollowerId(id, pageable);
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
    public boolean delete(@RequestParam Long id) {
        playlistService.delete(id);
        return true;
    }
}
