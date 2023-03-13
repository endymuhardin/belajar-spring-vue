<script setup lang="ts">
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <nav class="fixed z-30 w-full bg-white border-b-2 border-indigo-600">
      <div class="px-6 py-3">
        <div class="flex items-center justify-between">
          <div class="flex items-center justify-start">
            <button class="p-2 text-gray-600 rounded cursor-pointer lg:hidden ">
              <svg xmlns="http://www.w3.org/2000/svg" class="w-6 h-6" fill="none" viewBox="0 0 24 24"
                stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16" />
              </svg>
            </button>
            <a href="#" class="flex items-center text-xl font-bold">
              <span class="text-blue-800">Logo</span>
            </a>
          </div>
        </div>
      </div>
    </nav>
    <div class="pt-12 lg:flex">
      <div class="flex flex-col w-full px-4 py-8 overflow-y-auto border-b lg:border-r lg:h-screen lg:w-64">
        <div class="flex flex-col justify-between mt-6">
          <aside>
            <ul>
              <li>
                <RouterLink to="/">Home</RouterLink>
              </li>
              <li>
                <RouterLink to="/users">Users</RouterLink>
              </li>
              <li>
                <RouterLink to="/roles">Roles</RouterLink>
              </li>
            </ul>
          </aside>
        </div>
      </div>
      <div class="w-full h-full p-4 m-8 overflow-y-auto">
        <RouterView />
      </div>
    </div>
</template>