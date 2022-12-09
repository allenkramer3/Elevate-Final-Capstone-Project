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

  </div>
</template>

<script>

export default {
    name: "dj"
}
</script>

<style scoped>
  .btn-header {
    margin: 50px;
  }
</style>