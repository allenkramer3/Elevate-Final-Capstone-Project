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
    @JsonProperty("available_markets")
    private List<String> availableMarkets = null;
    @JsonProperty("disc_number")
    private Integer discNumber;
    @JsonProperty("duration_ms")
    private Integer durationMs;
    @JsonProperty("explicit")
    private Boolean explicit;
    @JsonProperty("external_ids")
    private ExternalIds externalIds;
    @JsonProperty("external_urls")
    private ExternalUrls__3 externalUrlsThree;
    @JsonProperty("href")
    private String trackHref;
    @JsonProperty("id")
    private String trackID;
    @JsonProperty("is_local")
    private Boolean isLocal;
    @JsonProperty("name")
    private String trackName;
    @JsonProperty("popularity")
    private Integer popularity;
    @JsonProperty("preview_url")
    private String previewUrl;
    @JsonProperty("track_number")
    private Integer trackNumber;
    @JsonProperty("type")
    private String typeTrack;
    @JsonProperty("uri")
    private String trackUri;

    @JsonProperty("album")
    public Album getAlbum() {
        return album;
    }

    @JsonProperty("album")
    public void setAlbum(Album album) {
        this.album = album;
    }

    @JsonProperty("artists")
    public List<Artist__1> getArtists() {
        return artists;
    }

    @JsonProperty("artists")
    public void setArtists(List<Artist__1> artists) {
        this.artists = artists;
    }

    @JsonProperty("available_markets")
    public List<String> getAvailableMarkets() {
        return availableMarkets;
    }

    @JsonProperty("available_markets")
    public void setAvailableMarkets(List<String> availableMarkets) {
        this.availableMarkets = availableMarkets;
    }

    @JsonProperty("disc_number")
    public Integer getDiscNumber() {
        return discNumber;
    }

    @JsonProperty("disc_number")
    public void setDiscNumber(Integer discNumber) {
        this.discNumber = discNumber;
    }

    @JsonProperty("duration_ms")
    public Integer getDurationMs() {
        return durationMs;
    }

    @JsonProperty("duration_ms")
    public void setDurationMs(Integer durationMs) {
        this.durationMs = durationMs;
    }

    @JsonProperty("explicit")
    public Boolean getExplicit() {
        return explicit;
    }

    @JsonProperty("explicit")
    public void setExplicit(Boolean explicit) {
        this.explicit = explicit;
    }

    @JsonProperty("external_ids")
    public ExternalIds getExternalIds() {
        return externalIds;
    }

    @JsonProperty("external_ids")
    public void setTrackExternalIds(ExternalIds externalIds) {
        this.externalIds = externalIds;
    }

    @JsonProperty("external_urls")
    public ExternalUrls__3 getExternalUrlsThree() {
        return externalUrlsThree;
    }

    @JsonProperty("external_urls")
    public void setTrackExternalUrls(ExternalUrls__3 externalUrlsThree) {
        this.externalUrlsThree = externalUrlsThree;
    }

    @JsonProperty("href")
    public String getTrackHref() {
        return trackHref;
    }

    @JsonProperty("href")
    public void setTrackHref(String trackHref) {
        this.trackHref = trackHref;
    }

    @JsonProperty("id")
    public String getTrackID() {
        return trackID;
    }

    @JsonProperty("id")
    public void setTrackID(String trackID) {
        this.trackID = trackID;
    }

    @JsonProperty("is_local")
    public Boolean getIsLocal() {
        return isLocal;
    }

    @JsonProperty("is_local")
    public void setIsLocal(Boolean isLocal) {
        this.isLocal = isLocal;
    }

    @JsonProperty("name")
    public String getTrackName() {
        return trackName;
    }

    @JsonProperty("name")
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    @JsonProperty("popularity")
    public Integer getPopularity() {
        return popularity;
    }

    @JsonProperty("popularity")
    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    @JsonProperty("preview_url")
    public String getPreviewUrl() {
        return previewUrl;
    }

    @JsonProperty("preview_url")
    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    @JsonProperty("track_number")
    public Integer getTrackNumber() {
        return trackNumber;
    }

    @JsonProperty("track_number")
    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    @JsonProperty("type")
    public String getTypeTrack() {
        return typeTrack;
    }

    @JsonProperty("type")
    public void setTypeTrack(String typeTrack) {
        this.typeTrack = typeTrack;
    }

    @JsonProperty("uri")
    public String getTrackUri() {
        return trackUri;
    }

    @JsonProperty("uri")
    public void setTrackUri(String trackUri) {
        this.trackUri = trackUri;
    }




}
