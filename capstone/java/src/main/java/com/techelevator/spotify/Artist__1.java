package com.techelevator.spotify;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "external_urls",
        "href",
        "id",
        "name",
        "type",
        "uri"
})
@Generated("jsonschema2pojo")

public class Artist__1 {

    @JsonProperty("external_urls")
    private ExternalUrls__2 externalUrlsTwo;
    @JsonProperty("href")
    private String artistHrefOne;
    @JsonProperty("id")
    private String artistIdOne;
    @JsonProperty("name")
    private String artistNameOne;
    @JsonProperty("type")
    private String typeArtistOne;
    @JsonProperty("uri")
    private String artistUriOne;

    @JsonProperty("external_urls")
    public ExternalUrls__2 getExternalUrlsTwo() {
        return externalUrlsTwo;
    }

    @JsonProperty("external_urls")
    public void setExternalUrls(ExternalUrls__2 externalUrlsTwo) {
        this.externalUrlsTwo = externalUrlsTwo;
    }

    @JsonProperty("href")
    public String getArtistHrefOne() {
        return artistHrefOne;
    }

    @JsonProperty("href")
    public void setArtistHrefOne(String artistHrefOne) {
        this.artistHrefOne = artistHrefOne;
    }

    @JsonProperty("id")
    public String getArtistIdOne() {
        return artistIdOne;
    }

    @JsonProperty("id")
    public void setArtistIdOne(String artistIdOne) {
        this.artistIdOne = artistIdOne;
    }

    @JsonProperty("name")
    public String getArtistNameOne() {
        return artistNameOne;
    }

    @JsonProperty("name")
    public void setArtistNameOne(String artistNameOne) {
        this.artistNameOne = artistNameOne;
    }

    @JsonProperty("type")
    public String getTypeArtistOne() {
        return typeArtistOne;
    }

    @JsonProperty("type")
    public void setTypeArtistOne(String typeArtistOne) {
        this.typeArtistOne = typeArtistOne;
    }

    @JsonProperty("uri")
    public String getArtistUriOne() {
        return artistUriOne;
    }

    @JsonProperty("uri")
    public void setArtistUriOne(String artistUriOne) {
        this.artistUriOne = artistUriOne;
    }


}
