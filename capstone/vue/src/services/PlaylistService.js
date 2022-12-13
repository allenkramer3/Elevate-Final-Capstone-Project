import axios from "axios";

export default {

    getSongs(eventID){
        return axios.get(`/song/playlist/${eventID}`)
    },

    search(searchText){
        return axios.get(`/search/tracks/${searchText}`)
    },

    addSong(song){
         return axios.post('/song/add', song)
     }

}