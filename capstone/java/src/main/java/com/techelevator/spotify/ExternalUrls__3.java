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

public class ExternalUrls__3 {

    @JsonProperty("spotify")
    private String spotify3;

    @JsonProperty("spotify")
    public String getSpotify3() {
        return spotify3;
    }

    @JsonProperty("spotify")
    public void setSpotify3(String spotify3) {
        this.spotify3 = spotify3;
    }


}
