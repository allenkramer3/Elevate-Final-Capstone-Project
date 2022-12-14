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
    private String AUTH_CODE = "AQAhIGJ4bOnNzMGJlftLnJhXtob_wkEPJAKeGroZ5R3yBWvZB2oaHTJjX1vfzL44LJr5rSvnDp_x5m-0lw1XGOT3PVS6gEvefxy1h4lxn4Fb3uAcpARmRlVeAKSG1KvoPRJHNbe81pqrKOQVfLOt-BexkRpfeiT3CQI9yAzTjkuDIlNHt1r67kEAoQXcy2f1bWnbrwp6S63DyMHjPDGwV_dmLdG_85bpBFfL1iQz3R8OCbNsdZFlnCQy9MpNnSl5UOFkSluQNp_oyiV6Js1L1pkgyd-RuzcNqZEebkoH1g33sGsuD49D6KWj5bEqNT9J4MZBK9dqqrAbOWn07e12crWJvQrB2gUXjU_6rNnwmaZnv_m8haASC9Hxy9wqNVTPJ807BWvfCtxJRQHbMLoFSNZRKjl_8Zuicnrr3eKShquaNvd8bfcmKadZHAd4oFh_3BPipzj9PxdQIavCkWOKF9TircwAbS1NvAdVN5aSyyZK7ykoCpUMV-SJddFO51ivNS-BvsglU8B1P7ZNJ4V-ySJDJmRktKrbLvClb6tekQGOAlar5lymCyiD2qk_CHb_d9keYAr85Vb1kcjt";
    private String ACCESS_TOKEN = "BQBhca5fC4T5yithnKKhRlMLD7cNKxa3m3Ex7bvOpbmjZz8ipFcEFe7UDq0lOlXSeZbbgAcLksbFepEtSYAenKUsoq8x6lB1puhtM6u9qvZpsyghmi1OEc_IoDiMedGubxoK8MIWYZ0pl9GtB50CtDM-FK7W7eKfLlLgGHZ_dzXmaoEfGocqHESTprLwUKTivp_1xjxDJzDdQzC-aZjxVSbutyKOV_Xbb5JQzHVb_988s58JLIYvvqla5uhUWultjZYV4wquzbO4ecUGGQ";
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
