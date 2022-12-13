package com.techelevator.dao;

import com.techelevator.model.Song;

import java.util.List;

public interface SongDao {

    List<Song> listSongs();

    String getTrackUri(String songName);

    List<String> listPlaylistSongs(String playlistName);
}
