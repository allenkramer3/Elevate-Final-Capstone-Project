<template>
  <div>
      <input type="text" v-model="searchText" @input="search" placeholder="Search" />
      <ul>
          <li v-for="result in results" v-bind:key="result.id">
              {{ result.title }}
          </li>
      </ul>
  </div>
</template>

<script>
import PlaylistService from '../services/PlaylistService';

export default {
    name: 'user-search',
    data() {
        return {
            searchText: '',
            results: []
        };
    },
    methods: {
        search() {
            PlaylistService
                .get(this.searchText)
                .then(response => {
                    this.results = response.data;
                });
        }
    }
};
</script>

<style>

</style>