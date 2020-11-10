package com.svetaukiyo.restApi.service;

import com.svetaukiyo.restApi.model.PagePlaylist;
import com.svetaukiyo.restApi.model.Playlist;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlaylistService {

    Playlist add(Playlist playlist);

    Playlist update(Playlist playlist);

    PagePlaylist getAll(Pageable pageable);

    List<Playlist> findAllByFollowerId(Long id);

    PagePlaylist findAllByArtistId(Long id, Pageable pageable);

    boolean delete(Long id);
}
