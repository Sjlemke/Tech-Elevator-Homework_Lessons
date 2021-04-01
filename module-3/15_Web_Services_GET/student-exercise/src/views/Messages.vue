<template>
  <div class="messages">
    <topic-details />
  </div>
</template>

<script>
import TopicDetails from '../components/TopicDetails.vue';

export default {
  name: 'Messages',
  components: {
    TopicDetails
  }
}
</script>
