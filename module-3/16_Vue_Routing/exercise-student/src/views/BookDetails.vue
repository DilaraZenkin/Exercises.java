<template>
  <div>
      <book-details :book="bookToDisplay" />

  </div>
</template>

<script>
import BookDetails from '../components/BookDetails.vue'
export default {
  components: { BookDetails },

  computed: {
    bookToDisplay() {
      const isbn = this.$route.params.isbn;
      const allBooks = this.$store.state.books.concat(this.$store.state.popularBooks);
      const output = allBooks.find(book => book.isbn == isbn);
      return output;
    }
  }

}
</script>

<style>

</style>



