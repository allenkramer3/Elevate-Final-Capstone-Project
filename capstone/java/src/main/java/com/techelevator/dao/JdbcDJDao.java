package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcDJDao implements DJDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcDJDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findDjIDByUserID (int userID) {
        String sql = "SELECT dj_id FROM dj WHERE user_id = ?;";
        int id = jdbcTemplate.queryForObject(sql, Integer.class, userID);
        if (id != 0) {
            return id;
        } else {
            return 0;
        }
    }

}
