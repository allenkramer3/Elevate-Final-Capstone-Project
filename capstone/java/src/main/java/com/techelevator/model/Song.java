package com.techelevator.model;

import java.util.Objects;

public class Song {

    private int songID;
    private String songName;
    private int artistID;
    private int genreID;

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return songID == song.songID && artistID == song.artistID && genreID == song.genreID && Objects.equals(songName, song.songName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songID, songName, artistID, genreID);
    }

    @Override
    public String toString() {
        return "Song{" +
                "songID=" + songID +
                ", songName='" + songName + '\'' +
                ", artistID=" + artistID +
                ", genreID=" + genreID +
                '}';
    }
}
