package com.svetaukiyo.restApi.repository;

import com.svetaukiyo.restApi.model.Playlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    Optional<Playlist> findByPlaylistName(String playlistName);

    Page<Playlist> findAllByFollowerId(Long id, Pageable pageable);

    Page<Playlist> findAllByArtistId(Long id, Pageable pageable);

    long countByArtist_Id(Long id);

    long countByFollower_Id(Long id);
}
