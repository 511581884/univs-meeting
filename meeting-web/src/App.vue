<template>
  <router-view />
</template>

<script>
import { onMounted } from "vue";

import store from "./store";

export default {
  name: "App",
  setup() {
    onMounted(() => {
      store.dispatch("fetchMeetings");
    });
  },
};
</script>
