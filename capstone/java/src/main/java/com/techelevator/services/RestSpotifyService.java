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
    private String callBackUrl = "http://localhost:8080/callback";
    private String AUTH_CODE = "";
    private String ACCESS_TOKEN = "";
    private String DEVICE_ID = "cdad209a657d405c11b2a017bea34a445d22cb1e";

    public String getAccessToken() throws RestClientResponseException {
        String spotifyUrl = "https://accounts.spotify.com/api/token";
        String authText = CLIENT_ID + ":" + CLIENT_SECRET;

        MultiValueMap<String, String> bodyData = new LinkedMultiValueMap<String, String>();
        bodyData.add("grant_type", "authorization_code");
        bodyData.add("redirect_uri", "http://localhost:8080/callback");
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

}
