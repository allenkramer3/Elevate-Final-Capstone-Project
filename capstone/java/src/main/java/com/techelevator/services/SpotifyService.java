package com.techelevator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techelevator.spotify.Tracks;

public interface SpotifyService {

    String getAccessToken() throws JsonProcessingException;
    String getDevices();
    String getArtistTopTracks();
    String startResumePlayback(String trackUri);
    String pausePlayback();
    String skipToNext();
    String searchForItem(String userSearch);
    String createPlaylist();
    String getUsersPlaylist();
    String addItemsToPlaylist(String trackUri, String playlistID);



}