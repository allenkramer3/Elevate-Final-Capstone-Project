package com.techelevator.dao;

import com.techelevator.model.Event;

public interface EventDao {

    void createNewEvent(Event newEvent, int dJID);

    void updateEvent(Event updatedEvent, int hostID);

}
