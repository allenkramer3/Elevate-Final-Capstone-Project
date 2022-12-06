package com.techelevator.model;

import java.util.Objects;

public class Host {

    private int hostID;

    private int userID;
    private int playlistID;

    public int getHostID() {
        return hostID;
    }

    public void setHostID(int hostID) {
        this.hostID = hostID;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Host eventHost = (Host) o;
        return hostID == eventHost.hostID  && userID == eventHost.userID && playlistID == eventHost.playlistID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostID, userID, playlistID);
    }

    @Override
    public String toString() {
        return "EventHost{" +
                "hostID=" + hostID +
                ", userID=" + userID +
                ", playlistID=" + playlistID +
                '}';
    }
}
