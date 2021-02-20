<template>
  <router-view />
</template>

<script lang="ts">
import { onMounted, defineComponent } from "vue";

import { useStore } from "@/hooks/store";
import { fetchToken } from "@/api/auth";

export default defineComponent({
  name: "App",
  setup() {
    const store = useStore();
    onMounted(async () => {
      await fetchToken();
      store.dispatch("meeting/fetchMeetings");
      store.dispatch("notification/fetchNotifications");
    });
  },
});
</script>
