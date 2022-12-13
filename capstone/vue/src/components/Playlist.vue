<template>
  <div>
      <h3>Playlist:</h3>
      <p>song 1</p>
      <p>song 2</p>
      <p>song 3</p>
      <p>song 4</p>
      <p v-for="song in songs" v-bind:key="song.song" >{{songs.song}}</p>
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
            PlaylistService.retrieveSongs(this.$route.params.eventID).then(response => {
                this.$store.commit("SET_CURRENT_PLAYLIST", response.data);
            })
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