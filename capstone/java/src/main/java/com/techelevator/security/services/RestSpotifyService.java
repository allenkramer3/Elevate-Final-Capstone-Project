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
    private String AUTH_CODE = "AQBSUFPwfrBTESsyipOgPUc4JfU_a0-Ggx3SjNHeSajPxQ3VFSv59S7QBHhq3AyExpjj63Kyy0n1rK-15UltZpWxOGQohFg790jLKCcIlj8qz2OdD77ECSwJwo2M0uNGzd1qvtOkWsRQNmYPCqNVUeoRjnUdcQtRcR8RGOwISzFVT_iu_N6anOYSWFgeEDH5ioOdARGhxC1pNt8q6gaLRXuchjPeIc2ojWpu5bvdrujycm79uC21z_qrxWw0R2nWaSI-Lejx6Q9y7nep-GQtLBPmgbquduD9k9sj__C2P9VS3RTENWkF5mQnynncbuKDAFzAnvhzvUGmJzsLCnVk1rF9AV9aKNRvxUqtRU8bN0jiFjXXshWMXmRZR-34qfC-_9Np1hel3-F0-4zSm0aXP2_5UcSAtFTHH-Jnq-bUllD1lyNkobJuP8U8CK1hiKyZB-wFl4HEozrdQu3NO4gxaX0cDCq04F7J_S372J9QL1Vrz29kZuI1aRdBAUHHI_5GNA8ZqWyJu5JjaXRN0jagDwNQ0P0wSOFhKuoNFCtVyiGBArXH88W-jCD7pLYXHEE9ZAWPXAqpMFHiofA_";
    private String ACCESS_TOKEN = "BQB49pDOLZYxoijFIl8Y6__vdPjnr8dJhu7PspFqAyc8u3745fwjZSscpi6yv-uxRIAnA5QkoNT_qKiDBWogTa_A4jjsH94Aey_wDZ07z5LoBIJMNuYaBiC3C0m-WM7IdT-bE0piCHN3fhp8w3Ze4Kb9G_Hn3QxO5LdOudp9zoBE1E8kaW5_MbHe1lXOARTcCT4_L_Q1HTnKDpIzxuSJ4WSno8izswtY9N6Dn1TxpCmnDJHtv1mkY5pwXQN-w0fC5ATAXpc2YYtDm9GvrQ";
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
