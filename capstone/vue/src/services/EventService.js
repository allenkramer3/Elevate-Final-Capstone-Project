import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:8080"
});

export default {

    getEvents() {
        return http.get('/events');
    }

}

axios