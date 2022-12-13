<template>
  <div>
      <input type="text" v-model="searchText" v-on:submit.prevent="search" @input="search" placeholder="Search" />
      <ul>
          <li v-for="result in results" v-bind:key="result.id" >
              <p >{{ result.name }}</p>
              -
              {{ result.artists[0].name }}
              <button v-on:click="addSong"> Add Song</button> 
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
                 trackUri: '',
                 songName: '',
                 artistName: '',
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
         addSong(){
<<<<<<< HEAD
              this.newSong.songName = this.results.name;
=======
              this.newSong = {
                         trackUri: this.results.uri,
                         songName: this.results.name,
                         artistName: this.results.artists,
                         genreID: '3'
                    }
             
             PlaylistService.addSong(this.newSong).then(response => {
                if(response.status === 201){
                    
                alert("Song added")
                }
             });
>>>>>>> 89af6311be1d1cc2ffa4dc313a6758a203d34520
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