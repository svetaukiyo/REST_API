package com.svetaukiyo.restApi.service.impl;

import com.svetaukiyo.restApi.dto.SongDto;
import com.svetaukiyo.restApi.dto.mapper.CustomConverter;
import com.svetaukiyo.restApi.exception.DeleteException;
import com.svetaukiyo.restApi.model.PageSong;
import com.svetaukiyo.restApi.model.Song;
import com.svetaukiyo.restApi.repository.SongRepository;
import com.svetaukiyo.restApi.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class SongServiceImpl implements SongService {

    private SongRepository songRepository;
    private final CustomConverter customConverter;

    @Autowired
    public SongServiceImpl(SongRepository songRepository, CustomConverter customConverter) {
        this.songRepository = songRepository;
        this.customConverter = customConverter;
    }


    @Override
    public Song add(Song song) {
        return songRepository.save(song);
    }

    @Override
    public PageSong getAll(Pageable pageable) {
        PageSong pageSong = new PageSong();
        pageSong.setPages(getPages(pageable));
        pageSong.setPlaylists(songRepository.findAll(pageable)
                .getContent()
                .stream().map(playlist -> customConverter.convertToDto(playlist, SongDto.class))
                .collect(Collectors.toList()));
        return pageSong;
    }

    private int getPages(Pageable pageable) {
        return (int) Math.ceil((double) songRepository.count() / pageable.getPageSize());
    }

    @Override
    public Song update(Song song) {
        return songRepository.save(song);
    }

    @Override
    public boolean delete(Long id) {
        if (!songRepository.existsById(id)) {
            throw new DeleteException("this song doesn't exists");
        }
        songRepository.deleteById(id);
        return true;
    }
}
