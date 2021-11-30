<template>
  <div>

    <products-list></products-list>
  </div>
</template>

<script>
import ProductsList from './components/ProductsList.vue';
export default {
  components: { ProductsList },};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}
</style>
