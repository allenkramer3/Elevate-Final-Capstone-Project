<template>
  <div>
      <h2>Playlist:</h2>
      <div v-for="song in playlist" v-bind:key="song.songName" >
        <h3>{{song.songName}}</h3>
        <p>By: {{song.artist}}</p>

          
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
            });
        }
    },
    computed: {
        playlist(){
            return this.$store.state.playlist;
        }
    }
}
</script>

<style>

</style>