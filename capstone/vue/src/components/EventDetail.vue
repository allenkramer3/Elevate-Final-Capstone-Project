<template>
  <div>
    <div class="loading" v-if="isLoading">
        <img src="../assets/loading_motion.gif" />
    </div>
    <div v-else>
        <h1>{{ event.eventName }}</h1>
        <p> {{ event.hostName }}</p>
        <router-link v-bind:to="{ name: 'edit-event', params: {eventID: $route.params.eventID} }" class="btn edit-event">Edit Event</router-link>
        <button class="btn delete-event" v-on:click="deleteEvent">Delete Event</button>
        <div class="status-message error" v-show="errorMsg !== ''">{{ errorMsg }}</div>
    </div>
  </div>
</template>

<script>
import EventService from "../services/EventService";

export default {
    name: 'event-card',
    props: {
        event: Object,
    },
    data() {
        return {
            isLoading: true,
            errorMsg: "",
        };
    },
    methods: {
       retrieveEvent() {
           EventService
            .getEvent(this.$route.params.eventID)
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
.btn.edit-event {
  color: #fff;
  text-decoration: none;
  background-color: #508ca8;
  border-color: #508ca8;
  margin-bottom: 10px;
}
.btn.delete-event {
  color: #fff;
  background-color: #ef031a;
  border-color: #ef031a;
  margin-bottom: 10px;
}
</style>