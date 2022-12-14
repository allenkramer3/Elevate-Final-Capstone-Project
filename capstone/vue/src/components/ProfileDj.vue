<template>
  <div>
      <h1>My Profile</h1>
      <div>
          <h2>My Events</h2>
          <ul>
              <li v-for="event in events" v-bind:key="event.eventID">{{ event.eventName }}</li>
          </ul>
      </div>
      <div>
          <h2>My Playlists</h2>
          <ul>
              <li v-for="playlist in playlists" v-bind:key="playlist.playlistURI">{{ playlist.playlistName }}</li>
          </ul>
      </div>
  </div>
</template>

<script>
import EventService from '../services/EventService.js';

export default {
    name: 'profile-dj',
    data() {
        return {
            events: [
                {
                    eventID: '',
                    djID: '',
                    hostID: '',
                    playlistUri: '',
                    eventName: '',
                    eventInformation: '',
                    genres: '',
                    eventPicture: ''
                }
            ],
            playlists: [
                {
                    playlistURI: '',
                    playlistName: ''
                }
            ]
        }
    },
    created() {
        this.retrieveDjEvents();
        this.retrieveDjPlaylists();
    },
    methods: {
        retrieveDjEvents() {
            EventService.getDjEvents(this.$route.params.djId).then(response => {
                this.events = response.data;
            });
        },
        retrieveDjPlaylists() {
            EventService.getPlaylists().then(response => {
                this.playlists = response.data;
            });
        }
    }
}
</script>

<style>

</style>