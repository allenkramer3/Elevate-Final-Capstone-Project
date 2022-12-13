package com.techelevator.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.spotify.Album;

import com.techelevator.spotify.Tracks;
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
    private String AUTH_CODE = "AQAhwwAVe3ThUSfx5NASkZXhuvpSZUw82PV9VkmOXjGBTy20QOBT_qNb6pd_8WQ24Hnp_dWBV45wvPDecHX2h2C2Ctkkbgfz6J_qBiy8Y9V07YAAOpyX6iltgtxCrt7xCtSwSaJm7sxUvKxR-bt1_id5GA6uQ8jxzaHXZ5-DEu8kvHReDojttA4GdH9_MbdrkawUgshHq_K4vWj9wTXP2aQCMgA5JtD-5T6GlVC8f9K_ooNbtzBd8W0bq6FBbHMUgSkym7o9KlU0_jFYNnYLuVKhvfc8b8FYOvtuwYwAE7t7cTKn-B6NXmT8QgCggc_N53soZhIvWTRBjGmClzbflR2x-RrR3-n7hCs9B28smRKLy_t_fLDQpqR4ZmyI26pzVl_mwhtMMDP6TBeXWi8BtDYzRG0n6etY7cDrOL_hlA5Ex-4OF_N5RiFJatIp8ZyoZ4UVnTiZbhv0MEELz5PNL1WGi9H_ezdtvFtpWesc5wddOGzpyw56TDlcmHj2nPzEj6JBa2dyiJVuwjorYWxw1ipZRfh6RxtoAchE57VW5sEpvYSKw0PV9oqVANSOKp8pccIqhcwd8dPt0KA0";
    private String ACCESS_TOKEN = "BQB3j4iT1MAu3yrso2D963QpHdRnYYEoPFMNDoUpuLOCC946fl2Z9K8NNhbDwqi4F2OuCjCjPdayZq6hz3RnGEq1DE-S02IXMWfRx9acPhQx3C4bTuZ-eFyC7BVLgWtZlOCkADQfGCGfp2MkWMzjHG7JnbMWcjvoL-eclJ9j7aSVGv7kmGHv5FBx3B3eRveP3v8yYTHnu4hD3rxlsiHss7V2N549sOlPrfGd39FgiFHlOUc8ZIkj6v3hTfs-1R32eSCX8J-Tw4xRKMSNLg";
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
       // bodyData.add("scope", SCOPE);

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

    public String startResumePlayback(String trackUri) throws RestClientResponseException {
        String spotifyUrl = "https://api.spotify.com/v1/me/player/play?device_id="+DEVICE_ID;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Bearer "+ ACCESS_TOKEN);
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        Album album = new Album();


        String jsonData = "{\"uris\":[\"" + trackUri + "\"]}";
        HttpEntity<Object> entity = new HttpEntity<>(jsonData, headers);

        // make an HTTP PUT request with headers
       ResponseEntity<String> response = restTemplate.exchange(spotifyUrl, HttpMethod.PUT, entity, String.class);
        //ResponseEntity<Tracks> response = restTemplate.exchange(spotifyUrl, HttpMethod.PUT, entity, Tracks.class);
        return "Song is playing!";
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

        try {
            Tracks tracks = new ObjectMapper().readValue(response.getBody().toString(), Tracks.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return response.getBody().toString();

    }

    @Override
    public String createPlaylist() {
        String spotifyUrl = BASE_SPOTIFY_URL + "users/arkramer702/playlists";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Bearer "+ ACCESS_TOKEN);
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        //String jsonData = "{\"name\":\"TechElevator111\"}";
        String playlistName = "";

        String jsonData = "{\"name\":\"" + playlistName + "\"}";


        HttpEntity entity = new HttpEntity(jsonData, headers);

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

    @Override
    public String addItemsToPlaylist(String trackUri, String playlistUri) {
        String playlistID = playlistUri.substring(16);
        String spotifyUrl = BASE_SPOTIFY_URL + "playlists/" + playlistID + "/tracks";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Bearer "+ ACCESS_TOKEN);
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        String jsonData = "{\"uris\":[\"" + trackUri + "\"]}";

        HttpEntity entity = new HttpEntity(jsonData,headers);

        ResponseEntity<String> response = restTemplate.exchange(spotifyUrl, HttpMethod.POST,entity, String.class, playlistUri);

        return response.getBody();

    }


}
