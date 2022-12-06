package com.techelevator.model;

import java.util.Objects;

public class Playlist {

    private int playlistID;
    private int genreID;
    private int djID;

    public int getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public int getDjID() {
        return djID;
    }

    public void setDjID(int djID) {
        this.djID = djID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return playlistID == playlist.playlistID && genreID == playlist.genreID && djID == playlist.djID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistID, genreID, djID);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistID=" + playlistID +
                ", genreID=" + genreID +
                ", djID=" + djID +
                '}';
    }
}
