<template>
  <div class="meeting-list">
    <div v-for="(meeting, index) in filteredMeetings" :key="meeting.id">
      <meeting-item
        :meeting="meeting"
        :separator="index !== filteredMeetings.length - 1"
        @meetingClick="handleMeetingClick"
      />
    </div>

    <no-meeting v-if="isEmpty" />
  </div>
</template>

<script>
import { computed } from "vue";
import { useRouter } from "vue-router";

import NoMeeting from "./NoMeeting.vue";
import MeetingItem from "./MeetingItem.vue";
import { useStore } from "@/hooks/store";
import { areSameDate } from "@/helpers/dateTime";

export default {
  components: { NoMeeting, MeetingItem },
  name: "MeetingList",
  props: ["selectedDate"],
  setup(props) {
    const store = useStore();
    const router = useRouter();

    const selectedDate = computed(() => props.selectedDate);
    const meetings = computed(() => store.getters["meeting/getMeetings"]);
    const isEmpty = computed(() => !filteredMeetings.value.length);

    const handleMeetingClick = (meetingId) => {
      router.push(`/details/${meetingId}`);
    };
    const filteredMeetings = computed(() => {
      return meetings.value.filter((meeting) => {
        return areSameDate(meeting.startDate, selectedDate.value);
      });
    });

    return {
      filteredMeetings,
      handleMeetingClick,
      isEmpty,
    };
  },
};
</script>

<style scoped lang="less">
.meeting-list {
  height: 30vh;
  overflow: scroll;
  width: 100%;
  padding: 10px 0;
}
</style>
