<script setup lang="ts">
  import { ref, onMounted } from 'vue';
  import { useRouter } from 'vue-router';
  import { UserManagementService } from '@/services/user_management';

  const service = new UserManagementService();
  const router = useRouter();

  const rolePage = ref({} as Page<Role>);
  const user = ref({
    "username" : "",
    "password" : "",
    "active" : true,
    "role" : {
      "id" : ""
    }
  } as User);

  onMounted(() => {
      service.findRoles().then(result => rolePage.value = result)
  })

  const save = (user: User) => {
    console.log(user)
    service.save(user).then(() => {
      router.push('/users/list')
    })
  }

</script>

<template>
  <h1 class="mt-0 mb-2 text-5xl font-medium leading-tight text-primary">
    User Form
  </h1>

  <form class="w-full max-w-sm">
    <div class="md:flex md:items-center mb-6">
      <div class="md:w-1/3">
        <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-full-name">
          Username
        </label>
      </div>
      <div class="md:w-2/3">
        <input v-model="user.username"
          class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
          id="username" type="text" placeholder="Input Username">
      </div>
    </div>
    <div class="md:flex md:items-center mb-6">
      <div class="md:w-1/3">
        <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-password">
          Password
        </label>
      </div>
      <div class="md:w-2/3">
        <input v-model="user.password"
          class="bg-gray-200 appearance-none border-2 border-gray-200 rounded w-full py-2 px-4 text-gray-700 leading-tight focus:outline-none focus:bg-white focus:border-purple-500"
          id="password" type="password" placeholder="******************">
      </div>
    </div>
    <div class="md:flex md:items-center mb-6">
      <div class="md:w-1/3">
        <label class="block text-gray-500 font-bold md:text-right mb-1 md:mb-0 pr-4" for="inline-password">
          Role
        </label>
      </div>
      <div class="md:w-2/3">
        <select v-model="user.role.id"
          class="block appearance-none w-full bg-gray-200 border border-gray-200 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
          id="grid-state">
          <option v-for="r in rolePage.content" :value="r.id">{{ r.name }}</option>
        </select>
        <div class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700">
          <svg class="fill-current h-4 w-4" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
            <path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z" />
          </svg>
        </div>
      </div>
    </div>
    <div class="md:flex md:items-center mb-6">
      <div class="md:w-1/3"></div>
      <label class="md:w-2/3 block text-gray-500 font-bold">
        <input v-model="user.active" class="mr-2 leading-tight" type="checkbox" checked>
        <span class="text-sm">
          Active
        </span>
      </label>
    </div>
    <div class="md:flex md:items-center">
      <div class="md:w-1/3"></div>
      <div class="md:w-2/3">
        <button @click="save(user)"
          class="shadow bg-purple-500 hover:bg-purple-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-8 rounded"
          type="button">
          Save
        </button>
        <div class="inline-block h-[2px] min-h-[1em] w-3 self-stretch bg-neutral-100 opacity-0 dark:opacity-0"></div>
        <button
          class="shadow bg-purple-500 hover:bg-purple-400 focus:shadow-outline focus:outline-none text-white font-bold py-2 px-8 rounded"
          type="button">
          Clear
        </button>
    </div>
  </div>
</form></template>