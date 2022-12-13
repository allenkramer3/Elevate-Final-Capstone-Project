package com.techelevator.dao;

import com.techelevator.model.Playlist;
import com.techelevator.model.Song;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPlaylistDao implements PlaylistDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcPlaylistDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> listDJPlaylists(int djID) {
        List<String> playlistNames = new ArrayList<>();
        String sql = "SELECT * FROM playlist WHERE dj_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, djID);
        while (results.next()){
            Playlist playlist = mapRowToPlaylist(results);
            playlistNames.add(playlist.getPlaylistName());
        }
        return playlistNames;
    }

    private Playlist mapRowToPlaylist(SqlRowSet rowSet){
        Playlist playlist = new Playlist();
        playlist.setPlaylistUri(rowSet.getString("playlist_uri"));
        playlist.setDjID(rowSet.getInt("dj_id"));
        playlist.setPlaylistName(rowSet.getString("playlist_name"));

        return playlist;
    }

//    @Override
//    public List<String> listPlaylistSongs(String playlistName){
//        List<String> songs = new ArrayList<>();
//        String sql = "SELECT song_name FROM song AS s JOIN playlist_song AS ps ON s.track_uri = ps.track_uri" +
//                "JOIN playlist AS p ON p.playlist_uri = ps.playlist_uri WHERE playlist_name = ?;";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, playlistName);
//        while (results.next()){
//            Song song = new Song();
//
//        }
//    }



}
