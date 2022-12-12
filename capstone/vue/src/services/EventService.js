import axios from "axios";



export default {

    addEvent(event) {
        return axios.post('/event/create', event)
    },

    updateEvent(event) {
        return axios.put(`/events/${event.id}`, event)
    },

    getEvent(eventID) {
        return axios.get(`/events/${eventID}`)
    },

    deleteEvent(eventID) {
        return axios.delete(`/events/${eventID}`);
    }

}

axios