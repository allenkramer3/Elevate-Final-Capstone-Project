package com.techelevator.model;

import java.util.Objects;

public class PlaylistSong {

    private int playlistID;
    private int songID;

    public int getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaylistSong that = (PlaylistSong) o;
        return playlistID == that.playlistID && songID == that.songID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistID, songID);
    }

    @Override
    public String toString() {
        return "PlaylistSong{" +
                "playlistID=" + playlistID +
                ", songID=" + songID +
                '}';
    }

}
