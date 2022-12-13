package com.techelevator.dao;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DJDao {

    int findDjIDByUserID (int userID);

    List<Map<String, String>> listHostNames();

}
