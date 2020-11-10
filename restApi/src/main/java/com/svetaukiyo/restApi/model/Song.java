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
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String songName;

    @Column
    private String photo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "song_artist",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private List<Artist> artists;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;
}
