package com.techelevator.spotify;

import java.awt.*;
import java.util.List;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "album_type",
        "artists",
        "available_markets",
        "external_urls",
        "href",
        "id",
        "images",
        "name",
        "release_date",
        "release_date_precision",
        "total_tracks",
        "type",
        "uri"
})
@Generated("jsonschema2pojo")

public class Album {

    @JsonProperty("album_type")
    private String albumType;
    @JsonProperty("artists")
    private List<Artist> artists = null;
    @JsonProperty("available_markets")
    private List<String> availableMarkets = null;
    @JsonProperty("external_urls")
    private ExternalUrls__1 externalUrls;
    @JsonProperty("href")
    private String albumHref;
    @JsonProperty("id")
    private String albumID;
    @JsonProperty("images")
    private List<Image> images = null;
    @JsonProperty("name")
    private String albumName;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("release_date_precision")
    private String releaseDatePrecision;
    @JsonProperty("total_tracks")
    private Integer totalTracks;
    @JsonProperty("type")
    private String typeAlbum;
    @JsonProperty("uri")
    private String albumUri;

    @JsonProperty("album_type")
    public String getAlbumType() {
        return albumType;
    }

    @JsonProperty("album_type")
    public void setAlbumType(String albumType) {
        this.albumType = albumType;
    }

    @JsonProperty("artists")
    public List<Artist> getArtists() {
        return artists;
    }

    @JsonProperty("artists")
    public void setArtists(List<Artist> artists) {
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

    @JsonProperty("external_urls")
    public ExternalUrls__1 getExternalUrls() {
        return externalUrls;
    }

    @JsonProperty("external_urls")
    public void setExternalUrls(ExternalUrls__1 externalUrls) {
        this.externalUrls = externalUrls;
    }

    @JsonProperty("href")
    public String getAlbumHref() {
        return getAlbumHref();
    }

    @JsonProperty("href")
    public void setAlbumHref(String albumHref) {
        this.albumHref = albumHref;
    }

    @JsonProperty("id")
    public String getAlbumID() {
        return albumID;
    }

    @JsonProperty("id")
    public void setAlbumID(String albumID) {
        this.albumID = albumID;
    }

    @JsonProperty("images")
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
    }

    @JsonProperty("name")
    public String getAlbumName() {
        return albumName;
    }

    @JsonProperty("name")
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @JsonProperty("release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("release_date")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @JsonProperty("release_date_precision")
    public String getReleaseDatePrecision() {
        return releaseDatePrecision;
    }

    @JsonProperty("release_date_precision")
    public void setReleaseDatePrecision(String releaseDatePrecision) {
        this.releaseDatePrecision = releaseDatePrecision;
    }

    @JsonProperty("total_tracks")
    public Integer getTotalTracks() {
        return totalTracks;
    }

    @JsonProperty("total_tracks")
    public void setTotalTracks(Integer totalTracks) {
        this.totalTracks = totalTracks;
    }

    @JsonProperty("type")
    public String getTypeAlbum() {
        return typeAlbum;
    }

    @JsonProperty("type")
    public void setTypeAlbum(String typeAlbum) {
        this.typeAlbum = typeAlbum;
    }

    @JsonProperty("uri")
    public String getAlbumUri() {
        return albumUri;
    }

    @JsonProperty("uri")
    public void setAlbumUri(String albumUri) {
        this.albumUri = albumUri;
    }
}
