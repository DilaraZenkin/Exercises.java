<template>
<div>
  <reading-list />
  <router-link :to="{name: 'addBook' }"> Add Book To Reading List </router-link>
  </div>
</template>

<script>
import ReadingList from '../components/ReadingList.vue'
export default {
  components: { ReadingList },

}
</script>

<style>

</style>