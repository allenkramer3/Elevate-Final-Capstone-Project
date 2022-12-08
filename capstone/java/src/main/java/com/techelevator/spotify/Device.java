package com.techelevator.spotify;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "is_active",
        "is_private_session",
        "is_restricted",
        "name",
        "type",
        "volume_percent"
})
@Generated("jsonschema2pojo")

public class Device {

    @JsonProperty("id")
    private String deviceID;
    @JsonProperty("is_active")
    private Boolean isActive;
    @JsonProperty("is_private_session")
    private Boolean isPrivateSession;
    @JsonProperty("is_restricted")
    private Boolean isRestricted;
    @JsonProperty("name")
    private String deviceName;
    @JsonProperty("type")
    private String type;
    @JsonProperty("volume_percent")
    private Integer volumePercent;

    @JsonProperty("id")
    public String getDeviceID() {
        return deviceID;
    }

    @JsonProperty("id")
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    @JsonProperty("is_active")
    public Boolean getIsActive() {
        return isActive;
    }

    @JsonProperty("is_active")
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @JsonProperty("is_private_session")
    public Boolean getIsPrivateSession() {
        return isPrivateSession;
    }

    @JsonProperty("is_private_session")
    public void setIsPrivateSession(Boolean isPrivateSession) {
        this.isPrivateSession = isPrivateSession;
    }

    @JsonProperty("is_restricted")
    public Boolean getIsRestricted() {
        return isRestricted;
    }

    @JsonProperty("is_restricted")
    public void setIsRestricted(Boolean isRestricted) {
        this.isRestricted = isRestricted;
    }

    @JsonProperty("name")
    public String getDeviceName() {
        return deviceName;
    }

    @JsonProperty("name")
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("volume_percent")
    public Integer getVolumePercent() {
        return volumePercent;
    }

    @JsonProperty("volume_percent")
    public void setVolumePercent(Integer volumePercent) {
        this.volumePercent = volumePercent;
    }



}
