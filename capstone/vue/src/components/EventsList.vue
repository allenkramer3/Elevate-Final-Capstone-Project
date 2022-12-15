<template>
  <div id ="background">
      <h1 class ="title">Elevate Events</h1>
      <div class="events">
            <div class="loading" v-if="isLoading === false">

                 <!-- <event-detail v-for="event in events" v-bind:event="event" v-bind:key="event.id" v-on:click="viewEventDetails(event.eventID)" /> -->
                <router-link v-bind:to="{name : 'event', params: {eventId: event.eventID}}" v-for="event in events" v-bind:key="event.eventID" class="links">
                    <div class="card">
                         <h1 class="cardTitle">{{event.eventName}}</h1>
                        <h3 class="cardInfo">{{event.eventInformation}}</h3>   
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
#background{
    background-color: transparent;
}

h1, h2{
    font-family: Arial, Helvetica, sans-serif;
    
}

.card {
    color: white;
    background: rgba(0,0,0,.75);

    border-radius: 5px;
    padding: 5px;
    margin: 10px;
    border: 2px solid;
    padding: 10px;
    box-shadow: 6px 4px 8px;
}
.card:hover{
    border-color: #ff00d4;
    box-shadow: 0 0 10px #ff00d4;
    
}



.card:hover::before{
      transform: scale(1.1);
      box-shadow: 0 0 20px #ff00d4;


    /* background-color:white;
    border-top-left-radius: 10px;
    border-bottom-left-radius: 10px;
    animation-name: example;
    animation-duration: 0.25s;
    border-left: 8px solid black;
    box-shadow: 0 14px 28px rgba(0,0,0,0.25), 0 10px 10px rgba(0,0,0,0.22); */
}

.links {
    text-decoration: none;
}

div {
    background-color: transparent;
}

.events {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color:transparent;
}
.event {
    background-color: transparent;
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
.title{
    text-align: center;
    color: white;
    text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
    font-style: italic;
    font-family: "Audiowide", sans-serif;
    padding-top: 10px;
    text-align: center;
}
.cardInfo{
    color: white;
    text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
    font-style: oblique;
}
.cardTitle{
    color: white;
    text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
    font-style: italic;
    font-family: "Audiowide", sans-serif;
    padding-top: 10px;
}
</style>