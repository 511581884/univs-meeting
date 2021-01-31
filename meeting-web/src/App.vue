<template>
  <router-view />
  <router-link to="/WeekView">周视图</router-link>
</template>

<script>
import { onMounted } from "vue";

import store from "./store";

export default {
  name: "App",
  setup() {
    onMounted(() => {
      store.dispatch("fetchMeetings");

      console.log("store.state: ", store.state);
    });
  },
};
</script>
