package com.techelevator.dao;

import com.techelevator.model.Event;
import com.techelevator.model.Song;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcSongDao implements SongDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcSongDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Song> listSongs() {
        List<Song> songs = new ArrayList<>();
        String sql = "SELECT * FROM song";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Song song = mapRowToSong(results);
            songs.add(song);
        }
        return songs;
    }


    @Override
    public String getTrackUri(String songName) {

        String sql= "SELECT track_uri FROM song WHERE song_name = ?;";
        String result = jdbcTemplate.queryForObject(sql,String.class, songName);
        if(result != null){
            return result;
        } else{
            return null;
        }

    }

    @Override
    public List<String> listPlaylistSongs(String playlistName) {
        List<String> songs = new ArrayList<>();
        String sql = "SELECT * FROM song AS s JOIN playlist_song AS ps ON s.track_uri = ps.track_uri " +
                "JOIN playlist AS p ON ps.playlist_uri = p.playlist_uri WHERE playlist_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, playlistName);
        while (results.next()){
            Song song = mapRowToSong(results);
            songs.add(song.getSongName());
        }
        return songs;
    }

    private Song mapRowToSong(SqlRowSet rowSet){
        Song song = new Song();
        song.setTrackUri(rowSet.getString("track_uri"));
        song.setSongName(rowSet.getString("song_name"));
        song.setArtistName(rowSet.getString("artist_name"));
        song.setGenreID(rowSet.getInt("genre_id"));
        return song;
    }


}
