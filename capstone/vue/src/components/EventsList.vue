<template>
  <div>
      <h1>Elevate Events</h1>
      <div class="events">
            <div class="loading" v-if="isLoading === false">
              <h2>List of Events:</h2>
                 <!-- <event-detail v-for="event in events" v-bind:event="event" v-bind:key="event.id" v-on:click="viewEventDetails(event.eventID)" /> -->
                <router-link v-bind:to="{name : 'event', params: {eventId: event.eventID}}" v-for="event in events" v-bind:key="event.eventID" class="links">
                    <div class="card">
                         <h1>{{event.eventName}}</h1>
                        <h3>{{event.eventInformation}}</h3>   
                    </div>
                    
                </router-link>
                 
            </div>
            <div v-else>
                <img src="../assets/loading_motion.gif"/>
            </div> 

          <!-- <div class="event" v-for="event in events" v-bind:key="event.id" v-bind:style="{'background-color': event.backgroundColor}" v-else>
              <router-link v-bind:to="{name: 'Event', params: {id: event.id}}">
                  {{event.title}}
              </router-link>
          </div> -->
        </div>
           
  </div>
</template>

<script>
import EventService from '../services/EventService';
// import EventService from '../services/EventService';
// import EventDetail from './EventDetail.vue';

export default {
  components: { 
    //   EventDetail 
    },
    // data() {
    //     return {
    //         events: [],
    //         isLoading: true
    //     };
    // },
    // created() {
    //     EventService.getEvents().then(response => {
    //         this.events = response.data;
    //         this.isLoading = false;
    //     });
    // },
    data() {
        return {
            isLoading: true
        }
    },
    created(){
        this.retrieveEvents();
    },
    computed: {
        events(){
            return this.$store.state.events;
        }
    },
    methods: {
        retrieveEvents(){
            EventService.getEvents().then(response => {
                this.$store.commit("SET_EVENTS", response.data);
                this.isLoading = false;
            });
        },
        viewEventDetails(eventId) {
            this.$router.push(`/events/${eventId}`)
        }
    }
};
</script>

<style scoped>
h1, h2{
    font-family: Arial, Helvetica, sans-serif;
    
}

.card {
    background-color: turquoise;
    color: black;
}

.links {
    text-decoration: none;
}

div {
    background-color: white;
}

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