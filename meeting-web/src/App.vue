<template>
  <router-view />
</template>

<script lang="ts">
import { onMounted, defineComponent } from "vue";
import { useStore } from "vuex";

export default defineComponent({
  name: "App",
  setup() {
    const store = useStore();

    onMounted(() => {
      store.dispatch("meeting/fetchMeetings");
      store.dispatch("notification/fetchNotifications");
    });
  },
});
</script>
