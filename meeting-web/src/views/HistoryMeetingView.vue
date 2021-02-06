<template>
  <View navBar navBarTitle="历史会议">
    <div v-for="meeting in meetings" :key="meeting.id">
      {{ meeting }}
    </div>
  </View>
</template>

<script lang="ts">
import View from "@/components/common/View.vue";
import { useStore } from "@/hooks/store";
import { computed } from "vue";

export default {
  components: { View },
  name: "HistoryMeetingView",
  setup() {
    const store = useStore();
    const meetings = computed(
      () => store.getters["meeting/getCategorizedByDate"]
    );
    console.log(meetings.value);

    return {
      meetings,
    };
  },
};
</script>

<style scoped></style>
