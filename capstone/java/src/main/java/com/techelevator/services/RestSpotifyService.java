package com.techelevator.services;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import java.util.Base64;

@Component
public class RestSpotifyService implements SpotifyService {

    private RestTemplate restTemplate = new RestTemplate();
    private final String AUTHORIZE_URL = "https://accounts.spotify.com/en/authorize";
    private String CLIENT_ID = "39164483b245448a9b0816a999571e93";
    private String CLIENT_SECRET = "8da81ffcd6d943d39e8c1ffa85a901cc";
    private String callBackUrl = "http://localhost:8080/dj/authorize";
    private String AUTH_CODE = "AQBHnOPnqUNGDb9nLC_6hFpydGK0IUTcVlabfm3FD_z4n1Nb-ghrK7ROVHUOzDqIuGmTsrx3wtMOAuuYQbRHw1M7LRXA7PDF6hQ5DQ35VhdfnMFzk341bHRkdsVPeEUi7yMFe8eS2e2fOBHSNNFFed-OszjpUmLk267ZNZffdAGSe637pzFM0-91l39Jf5GdlWIRpxtSBIu0S0MLJscxTKiw-pbcuzT4XPujYU2jc0tmOVve3Sb5pA3bNZ4fDlgEgSUkibF1KXz5nUeviEllzXX98HP63LNWHlAnDWz_es5i-KhDDfTF9wXuhBYiQ7yX-Uotq6WiOg";
    private String ACCESS_TOKEN = "BQCbt83J_sb0IdoRMBVquOGsiM01tAWi1GsBYjXhsLYpBdOrHV5MXXJwznY-ZEDps6o9HnGLXaitOFOzzC-GnzPI3Lc3diVYQHnI8sIynTtqXv6OhIXsxBk-yCLaQZ66hehve7S1MGzWJsezUCkVWEgKNQsEuWBpER4ZCDPvR9pDvuQjRJREktAzFJk17ux8OYoToGcrvX2S";
    private String DEVICE_ID = "73510ab9cdb61d2f22d2cebb814c604d29f23a3b";
    private final String BASE_SPOTIFY_URL = "https://api.spotify.com/v1/";
    //private final String SCOPE = "user-read-playback-state user-modify-playback-state user-read-currently-playing app-remote-control streaming playlist-read-private playlist-modify-public user-follow-modify user-follow-read user-read-playback-position user-top-read user-read-recently-played user-library-modify user-library-read";

    public String getAccessToken() throws RestClientResponseException {
        String spotifyUrl = "https://accounts.spotify.com/api/token";
        String authText = CLIENT_ID + ":" + CLIENT_SECRET;

        MultiValueMap<String, String> bodyData = new LinkedMultiValueMap<String, String>();
        bodyData.add("grant_type", "authorization_code");
        bodyData.add("redirect_uri", "http://localhost:8080/dj/authorize");
        bodyData.add("code", AUTH_CODE);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Basic "+ Base64.getEncoder().encodeToString(authText.getBytes()));
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        HttpEntity<Object> entity = new HttpEntity<>(bodyData, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(spotifyUrl, entity, String.class);

        return response.getBody();
    }

    public String getDevices() throws RestClientResponseException {
        String spotifyUrl = "https://api.spotify.com/v1/me/player/devices";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Bearer "+ ACCESS_TOKEN);

        HttpEntity entity = new HttpEntity(headers);

        // make an HTTP GET request with headers
        ResponseEntity<String> response = restTemplate.exchange(spotifyUrl, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public String getArtistTopTracks() throws RestClientResponseException {
        String spotifyUrl = "https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks?market=ES";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Bearer "+ ACCESS_TOKEN);
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        HttpEntity entity = new HttpEntity(headers);

        // make an HTTP GET request with headers
        ResponseEntity<String> response = restTemplate.exchange(spotifyUrl, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public String startResumePlayback() throws RestClientResponseException {
        String spotifyUrl = "https://api.spotify.com/v1/me/player/play?device_id="+DEVICE_ID;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Bearer "+ ACCESS_TOKEN);
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        String jsonData = "{\"context_uri\":\"spotify:album:5ht7ItJgpBH7W6vJ5BqpPr\",\"offset\":{\"position\":\"5\"},\"position_ms\":\"0\"}";

        HttpEntity<Object> entity = new HttpEntity<>(jsonData, headers);

        // make an HTTP PUT request with headers
        ResponseEntity<String> response = restTemplate.exchange(spotifyUrl, HttpMethod.PUT, entity, String.class);

        return response.getBody();
    }

    @Override
    public String pausePlayback() {
        String spotifyUrl = "https://api.spotify.com/v1/me/player/pause?device_id="+DEVICE_ID;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Bearer "+ ACCESS_TOKEN);
        headers.set("Content-Type", "application/x-www-form-urlencoded");


        HttpEntity<Object> entity = new HttpEntity<>(headers);

        // make an HTTP PUT request with headers
        ResponseEntity<String> response = restTemplate.exchange(spotifyUrl, HttpMethod.PUT, entity, String.class);

        return response.getBody();
    }

    @Override
    public String skipToNext() {
        String spotifyUrl = "https://api.spotify.com/v1/me/player/next?device_id="+DEVICE_ID;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Bearer "+ ACCESS_TOKEN);
        headers.set("Content-Type", "application/x-www-form-urlencoded");



        HttpEntity<Object> entity = new HttpEntity<>(headers);

        // make an HTTP PUT request with headers
        ResponseEntity<String> response = restTemplate.exchange(spotifyUrl, HttpMethod.POST, entity, String.class);

        return response.getBody();
    }

    public String searchForItem(String userSearch) throws RestClientResponseException {
        String spotifyUrl = BASE_SPOTIFY_URL + "search?q=" + userSearch + "&type=track&limit=10";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Bearer "+ ACCESS_TOKEN);
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(spotifyUrl, HttpMethod.GET,entity, String.class, userSearch);

        return response.getBody();

    }

    @Override
    public String createPlaylist() {
        String spotifyUrl = BASE_SPOTIFY_URL + "users/arkramer702/playlists";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Bearer "+ ACCESS_TOKEN);
        headers.set("Content-Type", "application/x-www-form-urlencoded");
       // headers.set("Scope", "Scope " + SCOPE);

        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(spotifyUrl, HttpMethod.POST,entity, String.class);

        return response.getBody();

    }

    @Override
    public String getUsersPlaylist() {
        String spotifyUrl = BASE_SPOTIFY_URL + "users/arkramer702/playlists";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Bearer "+ ACCESS_TOKEN);
        headers.set("Content-Type", "application/x-www-form-urlencoded");


        HttpEntity entity = new HttpEntity(headers);

        ResponseEntity<String> response = restTemplate.exchange(spotifyUrl, HttpMethod.GET,entity, String.class);

        return response.getBody();

    }


}
