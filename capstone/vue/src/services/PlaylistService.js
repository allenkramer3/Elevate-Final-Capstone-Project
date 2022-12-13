import axios from "axios";

export default {

    getSongs(eventID){
        return axios.get(`/song/playlist/${eventID}`)
    },

    search(userSearch){
        return axios.get(`/search/tracks/${userSearch}`)
    }

}