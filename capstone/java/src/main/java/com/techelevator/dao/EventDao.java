package com.techelevator.dao;


import com.techelevator.model.Event;

import java.util.List;

public interface EventDao {

    void createNewEvent(Event newEvent, int dJID);

    void updateEvent(Event updatedEvent, int hostID);

    List<Event> listOfEvents();

    void deleteEvent(int eventID);

}
