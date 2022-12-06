package com.techelevator.model;

import java.util.Objects;

public class Artist {

    private int artistID;
    private String artistName;

    public int getArtistID() {
        return artistID;
    }

    public void setArtistID(int artistID) {
        this.artistID = artistID;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return artistID == artist.artistID && Objects.equals(artistName, artist.artistName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistID, artistName);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistID=" + artistID +
                ", artistName='" + artistName + '\'' +
                '}';
    }
}
