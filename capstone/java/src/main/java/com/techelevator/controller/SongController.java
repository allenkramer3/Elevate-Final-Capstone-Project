package com.techelevator.controller;


import com.techelevator.dao.SongDao;
import com.techelevator.model.Event;
import com.techelevator.model.Song;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    private SongDao songDao;

    public SongController(SongDao songDao){
        this.songDao = songDao;
    }

    @RequestMapping(path="/list", method = RequestMethod.GET)
    public List<Song> listOfSongs(){
        return songDao.listSongs();
    }

    @RequestMapping(path="/uri/{songName}", method = RequestMethod.GET)
    public String getTrackUri(@PathVariable String songName){
        return songDao.getTrackUri(songName);
    }

    @RequestMapping(path="/playlist/{playlistName}", method = RequestMethod.GET)
    public List<String> listOfPlaylistSongs(@PathVariable String playlistName){
        return songDao.listPlaylistSongs(playlistName);
    }


}
