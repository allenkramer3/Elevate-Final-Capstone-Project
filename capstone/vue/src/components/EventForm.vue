<template>
  <form v-on:submit.prevent="createEvent" class="new-event-form">
      <div class="status-message error" v-show="errorMsg !== ''">{{ errorMsg }}</div>
      <div class="form-group">
          <label for="eventName">Event Name:</label>
          <input id="eventName" type="text" class="form-control" v-model="event.eventName" autocomplete="off" />
      </div>
      <div class="form-group">
          <label >Host Name:</label>
          <br>
          <!-- <input id="hostName" type="text" class="form-control" v-model="event.hostName" autocomplete="off" /> -->
          <select v-model="event.hostID">
              <option v-bind:value="host.hostID"  v-for="host in hosts" v-bind:key="host.hostID" >{{host.hostName}}</option>
          </select>
      </div>
      <div class="form-group">
          <label for="event-info">Event Information:</label>
          <input id="event-info" type="text" class="form-control" v-model="event.eventInformation" autocomplete="off" />
      </div>
      <div class="form-group">
          <label for="event-genres">Genre(s)</label>
          <input id="event-genres" type="text" class="form-control" v-model="event.genres" autocomplete="off" />
      </div>
      <div class="form-group">
          <label for="event-pic">Picture:</label>
          <input id="event-pic" type="text" class="form-control" v-model="event.eventPicture" autocomplete="off" />
      </div>
      <div class="form-group">
          <label >Assign Playlist: </label>
          <br>
          <select name="playlist-name" v-model="event.playlistUri" >
              <option v-bind:value="playlist.playlistURI" v-for="playlist in playlists" v-bind:key="playlist.playlistURI">{{playlist.playlistName}}</option>
          </select>
      </div>
      <button class="btn btn-submit">Create New Event</button>
      <button class="btn btn-cancel" v-on:click="cancelEvent" type="button">Cancel</button>
  </form>
</template>

<script>
import EventService from "../services/EventService.js";

export default {
    name: 'event-form',
    props: {
        eventID: {
            type: Number,
            default: 0
        }
    },
    data() {
        return {
            event: {
                hostID: 0,
                eventName: '',
                eventInformation: '',
                genres: '',
                eventPicture: '',
                playlistUri: '',

                
            },
            errorMsg: '',
            hostAsString: '',
            hostToInt: parseInt(this.hostAsString)
        };
    },
    methods: {
        createEvent() {
            const newEvent = {
                // eventID: Number(this.$route.params.eventID),
                eventName: this.event.eventName,
                hostName: this.event.hostName
            };

            if (this.eventID === 0){
                // add
                EventService
                    .addEvent(this.event)
                    .then(response => {
                        if (response.status === 201) {
                            // this.$router.push(`/events/${newEvent.eventID}`);
                            this.$router.push(`/events`);
                        }
                    })
                    .catch(error => {
                        this.handleErrorResponse(error, "adding");
                    });
            } else {
                // update
                newEvent.id = this.eventID;
                EventService
                    .updateEvent(newEvent)
                    .then(response => {
                        if (response.status === 200) {
                            this.$router.push(`/events/${newEvent.eventID}`);
                        }
                    })
                    .catch(error => {
                        this.handleErrorResponse(error, "updating");
                    });
            }

            
        },
        cancelEvent() {
            this.$router.push(`/dj`);
        },
        handleErrorResponse(error, verb) {
            if (error.response) {
                this.errorMsg = 
                "Error " + verb + " event. Response received was '" +
                error.response.statusText + "'.";
            } else if (error.request) {
                this.errorMsg =
                "Error " + verb + " event. Server could not be reached.";
            } else {
                this.errorMsg =
                "Error " + verb + " event. Request could not be created.";
            }
        },
        addNewEvent() {
            this.$store.commit("ADD_EVENT", this.event)
        },
        retrieveHosts(){
            EventService.getHosts().then(response => {
                this.$store.commit("SET_HOSTS", response.data)
            });
        },
        retrievePlaylists(){
            EventService.getPlaylists().then(response => {
                this.$store.commit("SET_PLAYLISTS", response.data)
            });
        }
    },
    created() {

        this.retrieveHosts();
        this.retrievePlaylists();

        if (this.eventID != 0) {
            EventService
                .getEvent(this.eventID)
                .then(response => {
                    this.event = response.data;
                })
                .catch(error => {
                    if (error.response && error.response.status === 400) {
                        alert(
                            "Event not available. You may have entered an invalid event ID."
                        );
                        this.$router.push({ name: 'Home'})
                    }
                });
        }
    }, 
    computed: {
        hosts(){
            return this.$store.state.hosts
        },
        playlists(){
            return this.$store.state.playlists
        },
    }
};
</script>

<style>
.new-event-form {
    padding: 10px;
    margin-bottom: 10px;
    background-color:rgb(233, 186, 233);
}

.form-group {
    margin-bottom: 10px;
    margin-top: 10px;
}

label {
    display: inline-block;
    margin-bottom: 0.5rem;
}

.form-control {
    display: block;
    width: 80%;
    height: 30px;
    padding: 0.375rem 0.75rem;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #495057;
    border: 1px solid #ced4da;
    border-radius: 0.25rem;
}

.btn-submit {
    color: #fff;
    background-color: #0062cc;
    border-color: #005cbf;
}

.btn-cancel {
    color: #fff;
    background-color: #dc3545;
    border-color: #dc3545;
}

.status-message {
    display: block;
    border-radius: 5px;
    font-weight: bold;
    font-size: 1rem;
    text-align: center;
    padding: 10px;
    margin-bottom: 10px;
}

.status-message.success {
    background-color: #90ee90;
}

.status-message.error {
    background-color: #f08080;
}
</style>