package com.techelevator.security.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.SearchResponseDTO;

import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component
public class RestSpotifyService implements SpotifyService {

    private RestTemplate restTemplate = new RestTemplate();
    private final String AUTHORIZE_URL = "https://accounts.spotify.com/en/authorize";
    private String CLIENT_ID = "39164483b245448a9b0816a999571e93";
    private String CLIENT_SECRET = "8da81ffcd6d943d39e8c1ffa85a901cc";
    private String callBackUrl = "http://localhost:8080/dj/authorize";
    private String AUTH_CODE = "AQAct7PkAycNTnwZulufcIikQ3BoqK67JO8nekOG38enAfN5ZvA5aNRuloUqr6JYjLC2QQtTLgQ-7wiDGTLu2snwTIKdV-qh182j6Dgceu3oinTFieQ9TDa45RMlsPOmhwEEXleeSack8C1No1fqo_XwKsdib8BcKKhCf4l0Vu7V9KQUglLi7V7P2VzAQSXGjAfOpjC5fZurdIFMk7lpAhp11y24p1SDbXkFmZq15rglyPky0VWOHk3RZ_i0SCu31h-Dg5bThrgRxhsilV6nm0d9UpML0aa2gAOTTaNVKjH8ytjvEpii1mN5N5O9PduIZvibEBjcXGeOSmCvmfG5uskGzw9VR3O1nQ4nrQhFAW3DhLGe5FOKTrCVVX_W5knjsYzbY08ZfAjMQ3oeuTBv1kWV5WIV_MnCM5B3DVxYXCe8Ik2zUT0JgN2mgWhp_aVNtlvSVNY83uTgh2w19loLLQIcJQjVnqc5wlvOqzz1c1Ogk5R0GIqC04e_DVboJ3Nl0tF_6hX7rgva0qU3tU3LTA59fC1bpqGSfCkoCZtmO_wxYbdE8qCsPxQkM7zVKJvC5Rp5VOmp-1o8RSKh";
    private String ACCESS_TOKEN = "BQDDap5WgYs6Nwvidq-2vazvBk2a-zKv674WI1vJpd3STKCkc3d2nIRIEQHrMSyhlfcGhVk93HVN0_qHuUbXidIQkdXXHrFuPouW6CNkzVvlzhxsxqPsdNjDYFLF2K4XXJmNDPsf6Am8mZcFluE6qlvKihwzlxlCV3k7J_SVEOu4eggf3ozHrb-c_GWa-nnJCEWN_Ax3Osqb3INZPdemDT6IrAmHMOr-MjJvjuCbWaUnayQD3q7X4sN0C2w7atTdrty8fQVtsZdQQg4saQ";
    private String DEVICE_ID = "73510ab9cdb61d2f22d2cebb814c604d29f23a3b";
    private final String BASE_SPOTIFY_URL = "https://api.spotify.com/v1/";


    private final JdbcTemplate jdbcTemplate;



    public RestSpotifyService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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

    public void startResumePlayback(int eventID) throws RestClientResponseException {
        String spotifyUrl = "https://api.spotify.com/v1/me/player/play?device_id="+DEVICE_ID;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Bearer "+ ACCESS_TOKEN);
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        String sql= "SELECT playlist_uri FROM event WHERE event_id = ?;";
        String result = jdbcTemplate.queryForObject(sql,String.class, eventID);


        String jsonData = "{\"context_uri\":\"" + result + "\",\"offset\":{\"position\":\"0\"},\"position_ms\":\"0\"}";
        HttpEntity<Object> entity = new HttpEntity<>(jsonData, headers);

        // make an HTTP PUT request with headers
       ResponseEntity<String> response = restTemplate.exchange(spotifyUrl, HttpMethod.PUT, entity, String.class);
    }

//    public void startResumePlaybackSong(String songName) throws RestClientResponseException {
//        String spotifyUrl = "https://api.spotify.com/v1/me/player/play?device_id="+DEVICE_ID;
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("Authorization","Bearer "+ ACCESS_TOKEN);
//        headers.set("Content-Type", "application/x-www-form-urlencoded");
//
//        String sql= "SELECT track_uri FROM song WHERE song_name = ?;";
//        String result = jdbcTemplate.queryForObject(sql,String.class, songName);
//
//
//        String jsonData = "{\"context_uri\":\"" + result + "\",\"offset\":{\"position\":\"0\"},\"position_ms\":\"0\"}";
//        HttpEntity<Object> entity = new HttpEntity<>(jsonData, headers);
//
//        // make an HTTP PUT request with headers
//        ResponseEntity<String> response = restTemplate.exchange(spotifyUrl, HttpMethod.PUT, entity, String.class);
//    }

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

        // make an HTTP POST request with headers
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
        String jsonData = response.getBody().toString();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JsonNode rootNode = null;
        try {
            rootNode = mapper.readValue(jsonData, JsonNode.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        JsonNode albumsNode = rootNode.path("tracks").path("items");
        List<SearchResponseDTO> searchList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            try {
                SearchResponseDTO searchObject = mapper.readValue(albumsNode.get(i).toString(), SearchResponseDTO.class);
                searchList.add(searchObject);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        String jsonResponse = null;
        try {
            jsonResponse = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(searchList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        //return response.getBody().toString();
        return jsonResponse;
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

        // make an HTTP POST request with headers
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

        // make an HTTP GET request with headers
        ResponseEntity<String> response = restTemplate.exchange(spotifyUrl, HttpMethod.GET,entity, String.class);

        return response.getBody();
    }

    @Override
    public String addItemsToPlaylist(String trackUri, String playlistUri) {
        String fullString = playlistUri;
        String separatedString = fullString.replace("%3A", ":");
        String correctString = separatedString.replace("=", "");

        String fullString2 = correctString;
        String[] separatedString2 = fullString2.split(":");
        String playlistID = separatedString2[2];

        String spotifyUrl = BASE_SPOTIFY_URL + "playlists/" + playlistID + "/tracks";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization","Bearer "+ ACCESS_TOKEN);
        headers.set("Content-Type", "application/x-www-form-urlencoded");

        String jsonData = "{\"uris\":[\"" + trackUri + "\"]}";

//        String messedUpString = playlistUri;
//        String[] separatedMessedUpString = messedUpString.split("\"");
//        String correctUri = separatedMessedUpString[3];





        String sql = "INSERT INTO playlist_song (playlist_uri, track_uri) " +
                     "VALUES (?, ?);";
        jdbcTemplate.update(sql, correctString, trackUri);

        HttpEntity entity = new HttpEntity(jsonData,headers);

        // make an HTTP POST request with headers
        ResponseEntity<String> response = restTemplate.exchange(spotifyUrl, HttpMethod.POST,entity, String.class);

        return response.getBody();
    }

}
