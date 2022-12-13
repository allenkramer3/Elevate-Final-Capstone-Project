package com.techelevator.dao;

import java.util.Map;

public interface DJDao {

    int findDjIDByUserID (int userID);

    Map<String, Integer> listHostNames();

}
