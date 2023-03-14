import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHashHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/users/list',
      name: 'usersList',
      component: () => import('../components/Users/UsersList.vue')
    },
    {
      path: '/users/form',
      name: 'usersForm',
      component: () => import('../components/Users/UsersForm.vue')
    },
    {
      path: '/roles',
      name: 'roles',
      component: () => import('../components/Roles/RolesList.vue')
    }
  ]
})

export default router