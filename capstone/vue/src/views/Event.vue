<template>
  <div>
   <event-detail />
   <events-list />
  </div>
</template>

<script>
import EventDetail from '../components/EventDetail.vue';
import EventsList from '../components/EventsList.vue';

export default {
    name: "event",
    components: {
      EventDetail,
        EventsList
    }
};
</script>

<style>

</style>