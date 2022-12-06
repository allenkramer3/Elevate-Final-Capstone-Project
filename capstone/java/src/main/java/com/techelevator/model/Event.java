package com.techelevator.model;

import java.util.Objects;

public class Event {

    private int eventID;
    private int djID;
    private String eventName;
    private String eventInformation;
    private int genreID;
    private String eventPicture;

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public int getDjID() {
        return djID;
    }

    public void setDjID(int djID) {
        this.djID = djID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventInformation() {
        return eventInformation;
    }

    public void setEventInformation(String eventInformation) {
        this.eventInformation = eventInformation;
    }

    public int getGenreID() {
        return genreID;
    }

    public void setGenreID(int genreID) {
        this.genreID = genreID;
    }

    public String getEventPicture() {
        return eventPicture;
    }

    public void setEventPicture(String eventPicture) {
        this.eventPicture = eventPicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return eventID == event.eventID && djID == event.djID && genreID == event.genreID && Objects.equals(eventName, event.eventName) && Objects.equals(eventInformation, event.eventInformation) && Objects.equals(eventPicture, event.eventPicture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventID, djID, eventName, eventInformation, genreID, eventPicture);
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventID=" + eventID +
                ", djID=" + djID +
                ", eventName='" + eventName + '\'' +
                ", eventInformation='" + eventInformation + '\'' +
                ", genreID=" + genreID +
                ", eventPicture='" + eventPicture + '\'' +
                '}';
    }
}
