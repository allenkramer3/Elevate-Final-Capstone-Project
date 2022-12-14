<template>
  <div>
      <input type="text" v-model="searchText" v-on:submit.prevent="search" @input="search" placeholder="Search" />
      <ul>
          <li v-for="result in results" v-bind:key="result.id" >
              {{ result.name }}
              -
              {{ result.artists[0].name }}
              <button v-on:click="addSong(result)"> Add Song</button> 
          </li>
      </ul>
      <button class="btn btn-search">Search</button>
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
                if(response.status === 201){
                    
                alert("Song added")
                }
             });
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

</style>