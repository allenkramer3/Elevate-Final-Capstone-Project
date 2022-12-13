import axios from "axios";

export default {

    getSongs(eventID){
        return axios.get(`playlist/${eventID}`)
    },

    search(userSearch){
        return axios.get(`/search/tracks/${userSearch}`)
    }

}