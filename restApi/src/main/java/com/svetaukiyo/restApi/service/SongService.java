package com.svetaukiyo.restApi.service;

import com.svetaukiyo.restApi.model.PageSong;
import com.svetaukiyo.restApi.model.Song;
import org.springframework.data.domain.Pageable;

public interface SongService {

    PageSong getAll(Pageable pageable);

    Song add(Song song);

    Song update(Song song);

    boolean delete(Long id);
}
