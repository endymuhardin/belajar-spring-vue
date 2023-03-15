import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHashHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: HomeView
    },
    {
      path: '/users/list',
      component: () => import('../components/Users/UsersList.vue')
    },
    {
      path: '/users/form/:id*',
      name: 'usersForm',
      component: () => import('../components/Users/UsersForm.vue'), 
      props: true
    },
    {
      path: '/roles',
      component: () => import('../components/Roles/RolesList.vue')
    }
  ]
})

export default router