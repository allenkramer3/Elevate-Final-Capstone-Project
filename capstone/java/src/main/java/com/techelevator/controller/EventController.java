package com.techelevator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.dao.DJDao;
import com.techelevator.dao.EventDao;
import com.techelevator.dao.HostDao;
import com.techelevator.dao.UserDao;

import com.techelevator.model.Event;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/event")
public class EventController {

    private EventDao eventDao;
    private UserDao userDao;
    private DJDao djDao;
    private HostDao hostDao;

    public EventController (EventDao eventDao, UserDao userDao, DJDao djDao, HostDao hostDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
        this.djDao = djDao;
        this.hostDao = hostDao;
    }

    private int getLoggedInUserID (Principal principal) {
        int loggedInUserID = userDao.findIdByUsername(principal.getName());
        return loggedInUserID;
    }

    @PreAuthorize("hasRole('DJ')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public void createNewEvent(@RequestBody Event event, Principal principal) {
        int userID = getLoggedInUserID(principal);
        int DjID = djDao.findDjIDByUserID(userID);
        eventDao.createNewEvent(event, DjID);
    }

    @PreAuthorize("hasAnyRole('HOST','DJ')")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public void updateEvent(@RequestBody Event event, Principal principal){
        int userId = getLoggedInUserID(principal);
        int hostID = hostDao.findHostIDByUserID(userId);
        eventDao.updateEvent(event, hostID);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path="/list", method = RequestMethod.GET)
    public List<Event> listOfEvents(){
        return eventDao.listOfEvents();
    }

    @PreAuthorize("hasRole('DJ')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path= "/delete/{eventID}", method = RequestMethod.DELETE)
    public void deleteEvent(@PathVariable int eventID){
        eventDao.deleteEvent(eventID);
    }



    // testing
//    @RequestMapping(path = "/song", method = RequestMethod.GET)
//    public Object findSongs(String songName) throws IOException, InterruptedException {
//        URL urlForGet = new URL("https://itunes.apple.com/search?term=jaded&entity=musicTrack&limit=1");
//        String readLine = null;
//        HttpURLConnection connection = (HttpURLConnection) urlForGet.openConnection();
//        connection.setRequestMethod("GET");
////        connection.setRequestProperty("userId", "1");
//        int responseCode = connection.getResponseCode();





//        InputStream responseStream = connection.getInputStream();
//
//
//        ObjectMapper mapper = new ObjectMapper();
//        SongResult song = mapper.readValue(responseStream, SongResult.class);
//        return song;

//        if (responseCode == HttpURLConnection.HTTP_OK){
//            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            StringBuffer response = new StringBuffer();
//            while ((readLine = in .readLine()) != null){
//                response.append(readLine);
//            } in .close();
//
//
//
//
//            String json = response.toString();
//
//
//
//
//            return json;
//        }

//        return null;
    }



