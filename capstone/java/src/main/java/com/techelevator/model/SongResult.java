package com.techelevator.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.processing.Generated;
import java.util.HashMap;
import java.util.Map;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "wrapperType",
        "kind",
        "artistId",
        "collectionId",
        "trackId",
        "artistName",
        "collectionName",
        "trackName",
        "collectionCensoredName",
        "trackCensoredName",
        "artistViewUrl",
        "collectionViewUrl",
        "trackViewUrl",
        "previewUrl",
        "artworkUrl30",
        "artworkUrl60",
        "artworkUrl100",
        "collectionPrice",
        "trackPrice",
        "releaseDate",
        "collectionExplicitness",
        "trackExplicitness",
        "discCount",
        "discNumber",
        "trackCount",
        "trackNumber",
        "trackTimeMillis",
        "country",
        "currency",
        "primaryGenreName",
        "contentAdvisoryRating",
        "isStreamable"
})

@Generated("jsonschema2pojo")
public class SongResult {

    @JsonProperty("artistId")
    private Integer artistId;
    @JsonProperty("trackId")
    private Integer trackId;
    @JsonProperty("artistName")
    private String artistName;
    @JsonProperty("trackName")
    private String trackName;
    @JsonProperty("artworkUrl100")
    private String artworkUrl100;
    @JsonProperty("trackTimeMillis")
    private Integer trackTimeMillis;
    @JsonProperty("primaryGenreName")
    private String primaryGenreName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("artistId")
    public Integer getArtistId() {
        return artistId;
    }

    @JsonProperty("artistId")
    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    @JsonProperty("trackId")
    public Integer getTrackId() {
        return trackId;
    }

    @JsonProperty("trackId")
    public void setTrackId(Integer trackId) {
        this.trackId = trackId;
    }

    @JsonProperty("artistName")
    public String getArtistName() {
        return artistName;
    }

    @JsonProperty("artistName")
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @JsonProperty("trackName")
    public String getTrackName() {
        return trackName;
    }

    @JsonProperty("trackName")
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }



    @JsonProperty("artworkUrl100")
    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    @JsonProperty("artworkUrl100")
    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }



    @JsonProperty("trackTimeMillis")
    public Integer getTrackTimeMillis() {
        return trackTimeMillis;
    }

    @JsonProperty("trackTimeMillis")
    public void setTrackTimeMillis(Integer trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    @JsonProperty("primaryGenreName")
    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    @JsonProperty("primaryGenreName")
    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


}
