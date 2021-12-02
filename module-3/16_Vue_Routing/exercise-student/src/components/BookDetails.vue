<template>
  <div>
     <h1>{{ book.title }}</h1>
     <h2>{{ book.author }}</h2>
      <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
     <h3>ISBN: {{ book.isbn }}</h3>
     <p>I have read this book<input type="checkbox" :checked="book.read"/></p>
  </div>
</template>
<script>
export default {
    props: ['book']
}
</script>
<style>
</style>