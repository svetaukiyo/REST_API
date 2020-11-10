package com.svetaukiyo.restApi.repository;

import com.svetaukiyo.restApi.model.Playlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    Optional<Playlist> findByPlaylistName(String playlistName);

    List<Playlist> findAllByFollowerId(Long id);

    Page<Playlist> findAllByArtistId(Long id, Pageable pageable);

    long countByArtist_Id(Long id);
}
