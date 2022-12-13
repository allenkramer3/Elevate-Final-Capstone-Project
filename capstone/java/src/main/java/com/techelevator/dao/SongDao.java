package com.techelevator.dao;

import com.techelevator.model.SearchResponseDTO;
import com.techelevator.model.Song;

import java.util.List;
import java.util.Map;

public interface SongDao {

    List<Song> listSongs();

    String getTrackUri(String songName);

    Map<String, String> listPlaylistSongs(int eventID);

    void createSong(SearchResponseDTO searchResponseDTO);

}
