package com.svetaukiyo.restApi.service.impl;

import com.svetaukiyo.restApi.dto.PlaylistDto;
import com.svetaukiyo.restApi.dto.mapper.CustomConverter;
import com.svetaukiyo.restApi.exception.DeleteException;
import com.svetaukiyo.restApi.model.PagePlaylist;
import com.svetaukiyo.restApi.model.Playlist;
import com.svetaukiyo.restApi.repository.PlaylistRepository;
import com.svetaukiyo.restApi.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private PlaylistRepository playlistRepository;
    private final CustomConverter customConverter;

    @Autowired
    public PlaylistServiceImpl(PlaylistRepository playlistRepository, CustomConverter customConverter) {
        this.playlistRepository = playlistRepository;
        this.customConverter = customConverter;
    }

    @Override
    public Playlist add(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public Playlist update(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    @Override
    public PagePlaylist getAll(Pageable pageable) {
        PagePlaylist pagePlaylist = new PagePlaylist();
        pagePlaylist.setPages(getPages(pageable));
        pagePlaylist.setPlaylists(playlistRepository.findAll(pageable)
                .getContent()
                .stream().map(playlist -> customConverter.convertToDto(playlist, PlaylistDto.class))
                .collect(Collectors.toList()));
        return pagePlaylist;
    }

    @Override
    public PagePlaylist findAllByFollowerId(Long id, Pageable pageable) {
        PagePlaylist pagePlaylist = new PagePlaylist();
        pagePlaylist.setPages(getPagesByFollower(pageable, id));
        pagePlaylist.setPlaylists(playlistRepository.findAllByFollowerId(id, pageable)
                .getContent()
                .stream().map(playlist -> customConverter.convertToDto(playlist, PlaylistDto.class))
                .collect(Collectors.toList()));
        return pagePlaylist;
    }
    @Override
    public PagePlaylist findAllByArtistId(Long id, Pageable pageable) {
        PagePlaylist pagePlaylist = new PagePlaylist();
        pagePlaylist.setPages(getPagesByArtist(pageable, id));
        pagePlaylist.setPlaylists(playlistRepository.findAllByArtistId(id, pageable)
                .getContent()
                .stream().map(playlist -> customConverter.convertToDto(playlist, PlaylistDto.class))
                .collect(Collectors.toList()));
        return pagePlaylist;
    }

    private int getPages(Pageable pageable) {
        return (int) Math.ceil((double) playlistRepository.count() / pageable.getPageSize());
    }

    private int getPagesByArtist(Pageable pageable, Long id) {
        return (int) Math.ceil((double) playlistRepository.countByArtist_Id(id) / pageable.getPageSize());
    }

    private int getPagesByFollower(Pageable pageable, Long id) {
        return (int) Math.ceil((double) playlistRepository.countByFollower_Id(id) / pageable.getPageSize());
    }

    @Override
    public boolean delete(Long id) {
        if (!playlistRepository.existsById(id)) {
            throw new DeleteException("this playlist doesn't exists");
        }
        playlistRepository.deleteById(id);
        return true;
    }
}
