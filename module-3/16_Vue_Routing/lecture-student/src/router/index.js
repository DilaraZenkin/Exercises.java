import Vue from 'vue'
import VueRouter from 'vue-router'
import ProductsList from '@/views/ProductsList.vue'
Vue.use(VueRouter)

const routes = [
{
  path: '/',
  component : ProductsList,
  name : 'products-list'
}
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
