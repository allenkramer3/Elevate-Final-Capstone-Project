package com.techelevator.dao;

import com.techelevator.model.Host;
import com.techelevator.model.User;

import java.util.List;
import java.util.Map;

public interface DJDao {

    int findDjIDByUserID (int userID);

    Map<String, Integer> listHostNames();

}
