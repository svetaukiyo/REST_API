package com.svetaukiyo.restApi.controller;

import com.svetaukiyo.restApi.dto.SongAddDto;
import com.svetaukiyo.restApi.dto.SongDto;
import com.svetaukiyo.restApi.dto.mapper.CustomConverter;
import com.svetaukiyo.restApi.model.PageSong;
import com.svetaukiyo.restApi.model.Song;
import com.svetaukiyo.restApi.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/song")
public class SongController {

    private static final int PAGE_SIZE = 4;

    private SongService songService;
    private CustomConverter customConverter;

    @Autowired
    public SongController(SongService songService, CustomConverter customConverter) {
        this.songService = songService;
        this.customConverter = customConverter;
    }

    @GetMapping("/all")
    public PageSong getAll(@PageableDefault(sort = {"songName"},
            direction = Sort.Direction.ASC,
            size = PAGE_SIZE) Pageable pageable) {
        return songService.getAll(pageable);
    }

    @PostMapping("/add")
    public SongAddDto addSong(@RequestBody Song song) {
        return customConverter.convertToDto(songService.add(song), SongAddDto.class);
    }

    @PostMapping("/update")
    public SongDto update(@Validated @RequestBody Song song) {
        return customConverter.convertToDto(songService.update(song), SongDto.class);
    }

    @PostMapping("/delete")
    public boolean delete(@RequestParam Long id) {
        songService.delete(id);
        return true;
    }
}
