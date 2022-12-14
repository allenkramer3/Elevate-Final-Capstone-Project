<template>
  <div>
    <br>
    <button>
        <router-link class="btn-header" v-bind:to="{ name: 'add-event'}">Create New Event</router-link>
        
    </button>
    <br>
    <br>
    <button>
      <router-link class="btn-header" v-bind:to="{ name: 'authorize'}">Authorize Page</router-link>
    </button>
    <button>
      <router-link class="btn-header" v-bind:to="{ name: 'dj-profile', params: {djId:djId}}">Dj Profile</router-link>
    </button>

  </div>
</template>

<script>
import AuthService from '../services/AuthService.js';

export default {
    name: "dj",
    data() {
      return {
        djId: ''
      }
    },
    created() {
        this.retrieveDjId();
    },
    // computed: {
    //   djId() {
    //     return this.$store.state.djId;
    //   }
    // }
    methods: {
      retrieveDjId() {
        AuthService.getDjId().then(response => {
          // this.$store.commit("SET_CURRENT_DJ", response.data);
          this.djId = response.data;
        });
      }
    }
}
</script>

<style scoped>
  .btn-header {
    margin: 50px;
  }
</style>