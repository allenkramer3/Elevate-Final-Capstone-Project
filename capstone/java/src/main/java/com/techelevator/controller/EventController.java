package com.techelevator.controller;

import com.techelevator.dao.DJDao;
import com.techelevator.dao.EventDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Event;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/event")
public class EventController {

    private EventDao eventDao;
    private UserDao userDao;
    private DJDao djDao;

    public EventController (EventDao eventDao, UserDao userDao, DJDao djDao) {
        this.eventDao = eventDao;
        this.userDao = userDao;
        this.djDao = djDao;
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

}
