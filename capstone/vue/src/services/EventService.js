import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {

    addEvent(event) {
        return http.post('/events', event)
    },

    updateEvent(event) {
        return http.put(`/events/${event.id}`, event)
    },

    getEvent(eventID) {
        return http.get(`/events/${eventID}`)
    },

    deleteEvent(eventID) {
        return http.delete(`/events/${eventID}`);
    }

}

axios