<template>
  <form id="frmAddNewBook" class="new-book-form">
      <div class="field">
        <label for="title">Title:</label>
        <input type="text" name="title" class="title-input" v-model="newBook.title" />
      </div>
      <div class="field">
        <label for="author">Author:</label>
        <input type="text" name="author" class="author-input" v-model="newBook.author" />
      </div>
      <div class="field">
        <label for="isbn">ISBN:</label>
        <input type="text" name="isbn" class="isbn-input" v-model="newBook.isbn" />
      </div>
      
      <button v-on:click.prevent="addBook">
        Add Book
      </button>
    </form>
</template>
<script>
import store from '@/store/index'
export default {
  name: "new-book-form",
  data() {
    return {
      newBook: {
        title: '',
        author: '',
        read: true,
        isbn: '',
      }
    }
  },
  methods: {
      addBook() {
        store.commit('addNewBook', this.newBook);
      }
  }
}
</script>