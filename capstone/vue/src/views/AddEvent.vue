<template>
  <div>
      <h1>Create New Event</h1>
      <event-form />
  </div>
</template>

<script>
import EventForm from "../components/EventForm.vue";

export default {
    name: "add-event",
    components: {
        EventForm
    }
};
</script>

<style>

</style>