package com.techelevator.controller;


import com.techelevator.dao.DJDao;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
//@PreAuthorize("isAuthenticated()")
@RequestMapping("/dj")
public class DJController {

    private DJDao djDao;

    public DJController (DJDao djDao){
        this.djDao = djDao;
    }

//    @PreAuthorize("hasRole('DJ')")
    @RequestMapping(value="/hosts", method = RequestMethod.GET)
    public List<Map<String, String>> getListOfHosts(){
        return djDao.listHostNames();
    }

}
