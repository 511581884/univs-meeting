<template>
  <div class="meeting-list">
    <div v-for="(meeting, index) in meetings" :key="meeting.id">
      <meeting-item
        :meeting="meeting"
        :separator="index !== meetings.length - 1"
        @meetingClick="handleMeetingClick"
      />
    </div>
  </div>
</template>

<script lang="ts">
import { computed } from "vue";
import { useRouter } from "vue-router";

import MeetingItem from "./MeetingItem.vue";

export default {
  components: { MeetingItem },
  name: "MeetingList",
  props: ["meetings"],
  setup(props) {
    const router = useRouter();
    const isEmpty = computed<boolean>(() => !props.meetings.length);

    const handleMeetingClick = (meetingId) => {
      router.push(`/details/${meetingId}`);
    };

    return {
      handleMeetingClick,
      isEmpty,
    };
  },
};
</script>

<style scoped lang="less">
.meeting-list {
  height: max-content;
  overflow: scroll;
  width: 100%;
  padding: 10px 0;
}
</style>
