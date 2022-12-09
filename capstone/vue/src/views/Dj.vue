<template>
  <div>
    <button>
        <router-link class="btn-header" v-bind:to="{ name: 'add-event'}">Create New Event</router-link>
    </button>
  </div>
</template>

<script>

export default {
    name: "dj"
}
</script>

<style>

</style>