import axios from "axios";

export default {

    getSongs(eventID){
        return axios.get(`playlist/${eventID}`)
    }

}