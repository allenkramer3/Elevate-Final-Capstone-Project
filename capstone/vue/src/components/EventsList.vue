<template>
  <div>
      <h1>Elevate Events</h1>
      <div class="events">
          <div class="loading" v-if="isLoading">
              <img src="../assets/loading_motion.gif"/>
          </div>
          <div class="event" v-for="event in events" v-bind:key="event.id" v-bind:style="{'background-color': event.backgroundColor}" v-else>
              <router-link v-bind:to="{name: 'Event', params: {id: event.id}}">
                  {{event.title}}
              </router-link>
          </div>
      </div>
  </div>
</template>

<script>
import EventService from '../services/EventService';

export default {
    data() {
        return {
            events: [],
            isLoading: true
        };
    },
    created() {
        EventService.getEvents().then(response => {
            this.events = response.data;
            this.isLoading = false;
        });
    }
};
</script>

<style scoped>
.events {
    display: flex;
    justify-content: space-between;
    align-items: center;
}
.event {
    background-color: #f7fafc;
    border-radius: 10px;
    padding: 40px;
    flex: 1;
    margin: 0 20px;
    text-align: center;
}
.loading {
    flex: 3;
}
.event a:link,
.event a:visited {
    color: rgb(243, 243, 243);
    text-decoration: none;
}
</style>