<template>
  <div>
      <h1>Edit Event</h1>
      <event-form v-bind:eventID="parseInt($route.params.eventID)" />
  </div>
</template>

<script>
import EventForm from "../components/EventForm.vue";

export default {
    name: "edit-event",
    components: {
        EventForm
    }
};
</script>

<style>

</style>