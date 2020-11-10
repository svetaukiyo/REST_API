package com.svetaukiyo.restApi.service;

import com.svetaukiyo.restApi.model.PagePlaylist;
import com.svetaukiyo.restApi.model.Playlist;
import org.springframework.data.domain.Pageable;

public interface PlaylistService {

    Playlist add(Playlist playlist);

    Playlist update(Playlist playlist);

    PagePlaylist getAll(Pageable pageable);

    PagePlaylist findAllByFollowerId(Long id, Pageable pageable);

    PagePlaylist findAllByArtistId(Long id, Pageable pageable);

    boolean delete(Long id);
}
