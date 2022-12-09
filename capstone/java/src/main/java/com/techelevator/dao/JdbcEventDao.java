package com.techelevator.dao;

import com.techelevator.controller.model.Event;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcEventDao implements EventDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcEventDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createNewEvent(Event newEvent, int dJID) {
        String sql = "INSERT INTO event (host_id, dj_id, event_name, event_information, genres, event_picture) " +
                     "VALUES (?, ?, ?, ?, ?, ?) ";
        jdbcTemplate.update(sql,  newEvent.getHostID(), dJID, newEvent.getEventName(), "", "", "");
    }

    @Override
    public void updateEvent(Event updatedEvent, int hostID){
        String sql = "UPDATE event SET event_name = ?, event_information = ?, genres = ?, event_picture = ?" +
                "WHERE event_id = ? AND host_id = ?";
        jdbcTemplate.update(sql, updatedEvent.getEventName(), updatedEvent.getEventInformation(), updatedEvent.getGenres(), updatedEvent.getEventPicture(), updatedEvent.getEventID(), hostID);
    }

}
