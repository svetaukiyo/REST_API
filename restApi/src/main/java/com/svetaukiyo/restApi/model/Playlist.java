package com.svetaukiyo.restApi.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String playlistName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "playlist")
    private List<Song> songs;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private Follower follower;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;
}
