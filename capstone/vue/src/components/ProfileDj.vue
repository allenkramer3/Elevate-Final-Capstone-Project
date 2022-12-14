<template>
  <div>
      <h1>My Profile</h1>
      <div>
          <h2>My Events</h2>
          <ul>
              <li v-for="event in events" v-bind:key="event.eventID"></li>
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
            events: {

            }
        }
    },
    created() {
        this.retrieveDjEvents();
    },
    methods: {
        retrieveDjEvents() {
            EventService.getDjEvents().then(response => {
                this.events = response.data;
            });
        }
    }
}
</script>

<style>

</style>