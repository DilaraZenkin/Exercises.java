<template>
  <div class="book-container">
    <book-card 
      v-for="book in $store.state.books"
      v-bind:key="book.isbn"
      :book="book"/>
    <new-book-form/>
  </div>
</template>
<script>
import BookCard from './BookCard.vue'
import NewBookForm from './NewBookForm'
export default {
  components: { BookCard, NewBookForm },
    name: 'reading-list'
}
</script>
<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}
</style>