package com.techelevator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.techelevator.services.SpotifyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
public class SpotifyController {

    private SpotifyService spotifyService;

    public SpotifyController(SpotifyService spotifyService) {
        this.spotifyService = spotifyService;
    }

    /**
     * These are the service calls to get spotify data and return JSON back to client
     */

    @RequestMapping(path = "/token", method = RequestMethod.GET)
    public String getSpotifyAccessToken() throws JsonProcessingException {
        //BEGIN - Just for information not needed
        URI currentUri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
        String asString = currentUri.toString();
        //END

        return spotifyService.getAccessToken();
    }

    @RequestMapping(path = "/devices", method = RequestMethod.GET)
    public String getSpotifyConnectedDevices() throws JsonProcessingException {
        return spotifyService.getDevices();
    }

    @RequestMapping(path = "/artist/tracks", method = RequestMethod.GET)
    public String getSpotifyArtistTopTracks() throws JsonProcessingException {
        return spotifyService.getArtistTopTracks();
    }

    @RequestMapping(path = "/play", method = RequestMethod.PUT)
    public String playSpotifyTrack() throws JsonProcessingException {
        return spotifyService.startResumePlayback();
    }

}
