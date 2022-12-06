package com.techelevator.model;

import java.util.Objects;

public class EventHost {

    private int hostID;
    private int eventID;
    private int userID;
    private int playlistID;

    public int getHostID() {
        return hostID;
    }

    public void setHostID(int hostID) {
        this.hostID = hostID;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
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
        EventHost eventHost = (EventHost) o;
        return hostID == eventHost.hostID && eventID == eventHost.eventID && userID == eventHost.userID && playlistID == eventHost.playlistID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostID, eventID, userID, playlistID);
    }

    @Override
    public String toString() {
        return "EventHost{" +
                "hostID=" + hostID +
                ", eventID=" + eventID +
                ", userID=" + userID +
                ", playlistID=" + playlistID +
                '}';
    }
}
