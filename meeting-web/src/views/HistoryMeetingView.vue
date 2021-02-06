<template>
  <View navBar navBarTitle="历史会议">
    <div v-for="key in Object.keys(meetingGroups)" :key="key">
      <list-header>{{ getDate(key) }}</list-header>
      <meeting-list :meetings="meetingGroups[key]" />
    </div>
  </View>
</template>

<script lang="ts">
import { computed } from "vue";
import { useRouter } from "vue-router";

import View from "@/components/common/View.vue";
import ListHeader from "@/components/common/ListHeader.vue";
import { useStore } from "@/hooks/store";
import { formatDate } from "@/helpers/dateTime";
import MeetingList from "@/components/meeting/MeetingList.vue";

export default {
  components: { View, ListHeader, MeetingList },
  name: "HistoryMeetingView",
  setup() {
    const store = useStore();
    const router = useRouter();

    const meetingGroups = computed(
      () => store.getters["meeting/getCategorizedByDate"]
    );
    const getDate = (dateString) => {
      return formatDate(new Date(dateString), false);
    };

    const handleMeetingClick = (meetingId) => {
      router.push(`/details/${meetingId}`);
    };

    return {
      getDate,
      handleMeetingClick,
      meetingGroups,
    };
  },
};
</script>

<style scoped></style>
