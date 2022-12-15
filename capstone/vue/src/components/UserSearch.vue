<template>
  <div class="searchInput">
      <input class="searchBox" type="text" v-model="searchText" v-on:submit.prevent="search" @input="search" placeholder="What song would you like to listen to?" />
      <ul>
          <li class="list" v-for="result in results" v-bind:key="result.id" >
              {{ result.name }}
              -
              {{ result.artists[0].name }}
              <button v-on:click="addSong(result); addToPlaylist(result)" >Request Song</button> 
              <!-- <button v-on:click="addToPlaylist()"> Request Song</button> -->
          </li>
      </ul>
      <!-- <button class="btn btn-search">Search</button> -->
  </div>
</template>

<script>
import PlaylistService from '../services/PlaylistService';

export default {
    name: 'user-search',
    data() {
        return {
            searchText: '',
            results: [],
            newSong: {
                 uri: '',
                 name: '',
                 artists: '',
                 genreID: '3'
             }
        };
    },
    methods: {
        search() {
            PlaylistService.search(this.searchText)
                .then(response => {
                    this.results = response.data;
                });
          },
         addSong(result){
              this.newSong = {
                         uri: result.uri,
                         name: result.name,
                         artists: result.artists[0].name,
                         genreID: '3'
                    }
             
             PlaylistService.addSong(this.newSong).then(response => {
                if(response.status === 200){
                this.addToPlaylist();
                }
             });
         },
         addToPlaylist(){
         PlaylistService.addToPlaylist(this.newSong.uri, this.$store.state.event.playlistUri).then(response =>{
             if(response.status === 200){
                 this.retrieveSongsList();
             }
         })
         
        
    },
     retrieveSongsList(){
            PlaylistService.getSongs(this.$route.params.eventId).then(response => {
                this.$store.commit("SET_CURRENT_PLAYLIST", response.data);
            })
        }

    },
    computed: {
        // songs(){
        //     return this.$store.state.songs;
        // }
    }
};
</script>

<style>

.searchInput{
    text-align: center;
    
}
.list{
    list-style-type: none;
}
.searchBox{
    width: 20%;
}


</style>