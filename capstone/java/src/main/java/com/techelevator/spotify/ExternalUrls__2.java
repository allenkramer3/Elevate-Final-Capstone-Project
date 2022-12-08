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

public class ExternalUrls__2 {

    @JsonProperty("spotify")
    private String spotify2;

    @JsonProperty("spotify")
    public String getSpotify2() {
        return spotify2;
    }

    @JsonProperty("spotify")
    public void setSpotify2(String spotify2) {
        this.spotify2 = spotify2;
    }


}
