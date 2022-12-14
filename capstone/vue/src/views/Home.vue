<template>
  <div class="home">

    <h1>Welcome to Elevate</h1>
    <h2>If you are an Elevate Host or DJ, please login below.</h2>
    <div class="btn-nav">
      <button class="home-nav" role="button">
        <router-link class="nav" v-bind:to="{ name: 'login'}">Login</router-link>
      </button>
      <h2>If you want to register as an Elevate Host or DJ, please register below.</h2>
      <button class="home-nav" role="button">
        <router-link class="nav" v-bind:to="{ name: 'register'}">Register</router-link>
      </button>
      <h2>Feel free to view any of our events by clicking on the dropdown of events.</h2>
      <div class="form-group">
          <label>
            <h2>Event Names:</h2>
          </label>
          <select>
              <option v-bind:value="event.routeID" v-for="event in events" v-bind:key="event.routeID">{{ event.eventName }}</option>
          </select>
          <button class="event-route" v-on:click="viewEventDetails(eventID)">
            Select Event
          </button>
      </div>    
    </div>
    <img src="../assets/Club.png" alt="Club" class="center">
  </div>
</template>

<script>
import EventService from '../services/EventService';

export default {
  name: "home",
  data() {
    return {
      routeID: ''
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
        },
        // routeToEvent() {
        //   this.$router.push(`events/`)
        // }
    }
};
</script>

<style scoped>

.home {
  background-image: linear-gradient(#000200, #4A007b, #9000BE, #A96BCB);
  height: 100vh;
}

h1 {
  color: white;
  text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
  font-style: italic;
  font-family: "Audiowide", sans-serif;
  padding-top: 10px;
  text-align: center;
}

.center {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
  border: 3px solid #ff00d4;
}

h2 {
  color: white;
  text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
  font-style: oblique;
  text-align: center;
}
  
.wrap{
  width: 50%;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.search {
  width: 100%;
  position: relative;
  display: flex;
}

.searchTerm {
  position:relative;  
  left:13%;
  top:25%;
  width:30%;
  width: 75%;
  border: 3px solid #ff00d4;
  border-right: none;
  padding: 5px;
  height: 20px;
  border-radius: 5px 0 0 5px;
  outline: none;
  color: #9DBFAF;
}

.search-icon {
  position: absolute;
  top: 10px;
  left: 635px;
  width: 14px; 
}

.searchTerm:focus{
  color: #000000;
}

.searchButton {
  width: 40px;
  height: 36px;
  border: 1px solid #ff00d4;
  background: #ff00b3;
  text-align: center;
  color: #fff;
  border-radius: 0 5px 5px 0;
  cursor: pointer;
  font-size: 20px;
}

.btn {
  margin: 0;
  position: absolute;
  left: 45%;
  border-radius: 6px; 
  border: none;
  color: rgb(0, 0, 0);
  padding: 5px 9px;
  font-size: 14px;
}

.btn-nav {
  display: grid;
  place-items: center;
}

.nav {
  text-decoration: none;
}

.home-nav {
  align-items: center;
  appearance: none;
  background-image: radial-gradient(100% 100% at 100% 0, #5adaff 0, #5468ff 100%);
  border: 0;
  border-radius: 6px;
  box-shadow: rgba(45, 35, 66, .4) 0 2px 4px,rgba(45, 35, 66, .3) 0 7px 13px -3px,rgba(58, 65, 111, .5) 0 -3px 0 inset;
  box-sizing: border-box;
  color: #fff;
  cursor: pointer;
  display: inline-flex;
  font-family: "JetBrains Mono",monospace;
  height: 48px;
  justify-content: center;
  line-height: 1;
  list-style: none;
  overflow: hidden;
  padding-left: 16px;
  padding-right: 16px;
  position: relative;
  text-align: left;
  text-decoration: none;
  transition: box-shadow .15s,transform .15s;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  white-space: nowrap;
  will-change: box-shadow,transform;
  font-size: 18px;
}

.home-nav:focus {
  box-shadow: #3c4fe0 0 0 0 1.5px inset, rgba(45, 35, 66, .4) 0 2px 4px, rgba(45, 35, 66, .3) 0 7px 13px -3px, #3c4fe0 0 -3px 0 inset;
}

.home-nav:hover {
  box-shadow: rgba(45, 35, 66, .4) 0 4px 8px, rgba(45, 35, 66, .3) 0 7px 13px -3px, #3c4fe0 0 -3px 0 inset;
  transform: translateY(-2px);
}

.home-nav:active {
  box-shadow: #3c4fe0 0 3px 7px inset;
  transform: translateY(2px);
}

</style>
