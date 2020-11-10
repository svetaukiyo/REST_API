package com.svetaukiyo.restApi.repository;

import com.svetaukiyo.restApi.model.Artist;
import com.svetaukiyo.restApi.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    Page<Song> findAllByArtistsId(Artist artists_id, Pageable pageable);

    long countByArtists_Id(Artist artists_id);
}
