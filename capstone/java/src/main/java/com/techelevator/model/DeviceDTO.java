package com.techelevator.model;

import java.util.Objects;

public class DeviceDTO {

    private String deviceID;

    public String getDeviceID() {
        return deviceID;
    }
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceDTO deviceDTO = (DeviceDTO) o;
        return Objects.equals(deviceID, deviceDTO.deviceID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceID);
    }

    @Override
    public String toString() {
        return "DeviceDTO{" +
                "deviceID='" + deviceID + '\'' +
                '}';
    }

}
