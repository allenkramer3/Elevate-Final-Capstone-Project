<template>
  <div >
    <div class="loading" v-if="isLoading">
        <img src="../assets/loading_motion.gif" />
    </div>
    <div v-else class="event-card">
        <h1>{{ events.eventName }}</h1>
        <p>Hello</p>
        <p> {{ events.hostName }}</p>
        <h3>{{events.eventInformation}}</h3>
        <h3>{{events.eventGenre}}</h3>
        <router-link v-bind:to="{ name: 'edit-event', params: {eventID: $route.params.eventId} }" class="btn edit-event">Edit Event</router-link>
        <button class="btn delete-event" v-on:click="deleteEvent">Delete Event</button>
        <div class="status-message error" v-show="errorMsg !== ''">{{ errorMsg }}</div>
        <div>
          <playlist />
          <user-search />
        </div>
        

    </div>
    
  </div>
</template>

<script>
import EventService from "../services/EventService";
import Playlist from './Playlist.vue';
import UserSearch from './UserSearch.vue';

export default {
  components: { Playlist, UserSearch },
    name: 'event-card',
    // props: {
    //     event: Object,
    // },
    data() {
        return {
            isLoading: false,
            errorMsg: "",
        };
    },
    methods: {
       retrieveEvent() {
           EventService
            .getEvent(this.$route.params.eventId)
            .then(response => {
                this.$store.commit("SET_CURRENT_EVENT", response.data);
                this.isLoading = false;
            })
            .catch(error => {
                if (error.response && error.response.status === 400) {
                    alert("Event not available. You may have entered and invalid event ID.");
                    this.$router.push({ name: 'events' });
                }
            });
       },
       deleteEvent() {
           if (
               confirm("Are you sure you want to delete this event? This cannot be undone.")
           ) {
               EventService
                .deleteEvent(this.event.eventID)
                .then(response => {
                    if (response.status === 200) {
                        alert("Event successfully deleted");
                        this.$router.push(`events/${this.event.eventID}`);
                    }
                })
                .catch(error => {
                    if (error.response) {
                        this.errorMsg = "Error deleting event. Response received was '" + error.response.statusText + "'.";
                    } else if (error.request) {
                        this.errorMsg = "Error deleting event. Server could not be reached.";
                    } else {
                        this.errorMsg = "Error deleting event. Request could not be created.";
                    }
                });
           }
       },
    },
    created() {
        this.retrieveEvent();
    },
    computed: {
        events() {
            return this.$store.state.event
        }
    }
};
</script>

<style>
.event-card {
    font-family: Arial, Helvetica, sans-serif;
    background-color: rgba(144, 0, 190, .2);
    border-radius: 10px;
    padding: 10px 10px 10px 10px;
    margin: 5px 5px 5px 5px;
}
.btn.edit-event {
  text-decoration: none;
  color: white;
  background-color: #508ca8;
  border: solid black;
  border-width: 1px;
  padding: 5px 5px 5px 5px;
  margin-bottom: 10px;
  margin-left: 20px;
  border-radius: 3px;
  font-size: 15px;
}
.btn.delete-event {
  color: #fff;
  background-color: #ef031a;
  border: solid black;
  border-width: 1px;
  margin-bottom: 10px;
  margin-left: 20px;
  padding: 5px 5px 5px 5px;
  border-radius: 3px;
  font-size: 15px;
}



</style>