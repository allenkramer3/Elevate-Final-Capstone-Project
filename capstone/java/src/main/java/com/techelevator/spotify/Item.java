package com.techelevator.spotify;

import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "album",
        "artists",
        "available_markets",
        "disc_number",
        "duration_ms",
        "explicit",
        "external_ids",
        "external_urls",
        "href",
        "id",
        "is_local",
        "name",
        "popularity",
        "preview_url",
        "track_number",
        "type",
        "uri"
})
@Generated("jsonschema2pojo")
public class Item {

    @JsonProperty("album")
    private Album album;
    @JsonProperty("artists")
    private List<Artist__1> artists = null;
    @JsonProperty("name")
    private String trackName;
    @JsonProperty("uri")
    private String trackUri;


    @JsonProperty("artists")
    public List<Artist__1> getArtists() {
        return artists;
    }

    @JsonProperty("artists")
    public void setArtists(List<Artist__1> artists) {
        this.artists = artists;
    }



    @JsonProperty("name")
    public String getTrackName() {
        return trackName;
    }

    @JsonProperty("name")
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }


    @JsonProperty("uri")
    public String getTrackUri() {
        return trackUri;
    }

    @JsonProperty("uri")
    public void setTrackUri(String trackUri) {
        this.trackUri = trackUri;
    }

    @JsonProperty("album")
    public Album getAlbum() {
        return album;
    }
    @JsonProperty("album")
    public void setAlbum(Album album) {
        this.album = album;
    }


}
