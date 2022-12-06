package com.techelevator.dao;

import com.techelevator.model.Event;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcEventDao implements EventDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcEventDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createNewEvent(Event newEvent, int dJID) {
        Event createdEvent = new Event();
        String sql = "INSERT INTO event (host_id, dj_id, event_name, event_information, genres, event_picture) " +
                     "VALUES (?, ?, ?, ?, ?, ?) ";
        jdbcTemplate.update(sql, Integer.class, createdEvent.getHostID(), dJID, createdEvent.getEventName(), "", "", "");
    }

}
