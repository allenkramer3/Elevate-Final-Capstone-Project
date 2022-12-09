package com.techelevator.services;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface SpotifyService {

    String getAccessToken() throws JsonProcessingException;
    String getDevices();
    String getArtistTopTracks();
    String startResumePlayback();

}