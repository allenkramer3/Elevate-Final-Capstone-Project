<template>
  <div>
      <h2>Playlist:</h2>
      <div class="scroll">
        <div class="song" v-for="song in playlist" v-bind:key="song.songName" >
        <h3>{{song.songName}}</h3>
        <p class = "artist">By: {{song.artist}}</p>
       </div>
          
        </div>
  </div>
</template>

<script>
import PlaylistService from "../services/PlaylistService"

export default {
    name: "playlist",
    created() {
        this.retrieveSongs();
    },
    methods: {
        retrieveSongs(){
            PlaylistService.getSongs(this.$route.params.eventId).then(response => {
                this.$store.commit("SET_CURRENT_PLAYLIST", response.data);
            })
        }
    },
    computed: {
        playlist(){
            return this.$store.state.playlist;
        },
        
    },
    
}
</script>

<style>

.scroll{
    overflow-y: scroll;
    height: 400px;
    border: 5px solid black;
    border-radius: 5px;
    padding: 10px;
    
}
.song {
    border-style: solid;
    border: 2px solid #9000BE;
    border-radius: 5px;
    padding: 5px;
    margin: 10px;
    border: 2px solid;
    padding: 10px;
    box-shadow: 6px 4px 8px;
    font-family: "Audiowide";
    
}


</style>