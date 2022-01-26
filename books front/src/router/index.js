import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/login',
    name:"Login",
    component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')

  },
  {
    path: '/register',
    name:"Register",
    component: () => import(/* webpackChunkName: "about" */ '../views/Register.vue')

  },
  {
    path: '/books',
    name:"Books",
    component: () => import(/* webpackChunkName: "about" */ '../views/Books.vue')

  },
  {
    path: '/admin',
    name:"Admin",
    component: () => import(/* webpackChunkName: "about" */ '../views/Admin.vue')

  },
  {
    path: '/update',
    name:"Update",
    component: () => import(/* webpackChunkName: "about" */ '../views/Update.vue')

  }
  
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
