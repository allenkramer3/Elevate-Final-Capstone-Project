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

public class Artist {

    @JsonProperty("external_urls")
    private ExternalUrls artistExternalUrls;
    @JsonProperty("href")
    private String artistHref;
    @JsonProperty("id")
    private String artistID;
    @JsonProperty("name")
    private String artistName;
    @JsonProperty("type")
    private String typeArtist;
    @JsonProperty("uri")
    private String artistUri;

    @JsonProperty("external_urls")
    public ExternalUrls getArtistExternalUrls() {
        return artistExternalUrls;
    }

    @JsonProperty("external_urls")
    public void setArtistExternalUrls(ExternalUrls artistExternalUrls) {
        this.artistExternalUrls = artistExternalUrls;
    }

    @JsonProperty("href")
    public String getArtistHref() {
        return artistHref;
    }

    @JsonProperty("href")
    public void setArtistHref(String artistHref) {
        this.artistHref = artistHref;
    }

    @JsonProperty("id")
    public String getArtistID() {
        return artistID;
    }

    @JsonProperty("id")
    public void setArtistID(String artistID) {
        this.artistID = artistID;
    }

    @JsonProperty("name")
    public String getArtistName() {
        return artistName;
    }

    @JsonProperty("name")
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @JsonProperty("type")
    public String getTypeArtist() {
        return typeArtist;
    }

    @JsonProperty("type")
    public void setTypeArtist(String typeArtist) {
        this.typeArtist = typeArtist;
    }

    @JsonProperty("uri")
    public String getArtistUri() {
        return artistUri;
    }

    @JsonProperty("uri")
    public void setArtistUri(String artistUri) {
        this.artistUri = artistUri;
    }

}
