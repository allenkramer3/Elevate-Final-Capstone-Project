package com.techelevator.controller;


import com.techelevator.dao.PlaylistDao;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistController{

    private PlaylistDao playlistDao;

    public PlaylistController(PlaylistDao playlistDao){
        this.playlistDao = playlistDao;
    }

    @RequestMapping(path="/dj/{djID}", method = RequestMethod.GET)
    public List<String> getDJPlaylistNames(@PathVariable int djID){
        return playlistDao.listDJPlaylists(djID);
    }

}
