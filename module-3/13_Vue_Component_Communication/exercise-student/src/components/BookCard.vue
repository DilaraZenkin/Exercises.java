<template>
  <div class="card">
    <h2 class="book-title">
        {{book.title}}
    </h2>
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <h3 class="book-author">
        {{book.author}}
    </h3>
    <button v-if="book.read" v-on:click.prevent="updateReadStatus(book.isbn)" class="mark-read">
        Mark Unread
    </button>
    <button v-if="!book.read" v-on:click.prevent="updateReadStatus(book.isbn)" class="mark-unread">
        Mark Read
    </button>
  </div>
</template>
<script>
import store from '@/store/index'
export default {
    name: 'book-card',
    props: ['book'],
    methods: {
        updateReadStatus(isbn) {
            store.commit('updateReadStatus', isbn);
        }
    }
}
</script>
<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
}
.card.read {
    background-color: lightgray;
}
.card .book-title {
    font-size: 1.5rem;
}
.card .book-author {
    font-size: 1rem;
}
</style>