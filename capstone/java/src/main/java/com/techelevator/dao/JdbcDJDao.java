package com.techelevator.dao;

import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.*;

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

    @Override
    public Map<String, Integer> listHostNames(){
        List<User> hosts = new ArrayList<>();
        String sql = "SELECT * FROM users WHERE role = 'ROLE_HOST'";
        SqlRowSet rowSet= jdbcTemplate.queryForRowSet(sql);
        while (rowSet.next()){
            hosts.add(mapRowToUser(rowSet));
        }
        Map<String, Integer> usernames = new HashMap<>();
        for(User user: hosts){
            String sql2 = "SELECT host_id FROM host WHERE user_id = ?";
            Integer hostID = jdbcTemplate.queryForObject(sql2, Integer.class, user.getId());
            usernames.put(user.getUsername(), hostID);
        }
        return usernames;
    }

    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password_hash"));
        user.setAuthorities(Objects.requireNonNull(rs.getString("role")));
        user.setActivated(true);
        return user;
    }

}
