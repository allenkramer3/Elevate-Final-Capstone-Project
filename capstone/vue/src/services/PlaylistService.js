import axios from "axios";

export default {

    getSongs(eventID){
        return axios.get(`/song/playlist/${eventID}`)
    },

    search(searchText){
        return axios.get(`/search/tracks/${searchText}`)
    },

    addSong(newSong){
         return axios.post('/song/add', newSong)
     }

}