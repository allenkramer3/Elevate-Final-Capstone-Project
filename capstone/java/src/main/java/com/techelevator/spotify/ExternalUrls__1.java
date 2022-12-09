package com.techelevator.spotify;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "spotify"
})
@Generated("jsonschema2pojo")

public class ExternalUrls__1 {

    @JsonProperty("spotify")
    private String spotify1;

    @JsonProperty("spotify")
    public String getSpotify1() {
        return spotify1;
    }

    @JsonProperty("spotify")
    public void setSpotify1(String spotify1) {
        this.spotify1 = spotify1;
    }



}
