<template>
  <div class="meeting-list">
    <div
      class="meeting-item"
      v-for="(meeting, index) in filteredMeetings"
      :key="meeting.id"
    >
      <div class="meeting-info">
        <div class="container-left">
          <h4 class="meeting-name">{{ meeting.name }}</h4>
          <h5 class="meeting-location">{{ meeting.location }}</h5>
        </div>
        <meeting-time
          :startDate="meeting.startDate"
          :endDate="meeting.endDate"
        ></meeting-time>
      </div>
      <separator v-if="index !== filteredMeetings.length - 1" />
    </div>
    <no-meeting v-if="isEmpty" />
  </div>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
import dayjs from "dayjs";

import Separator from "../common/Separator";
import MeetingTime from "./MeetingTime";
import NoMeeting from "../month/NoMeeting";
import { areSameDate } from "@/helpers/dateTime";

export default {
  components: { MeetingTime, Separator, NoMeeting },
  name: "MeetingList",
  props: ["selectedDate"],
  setup(props) {
    const store = useStore();

    const selectedDate = computed(() => props.selectedDate);
    const meetings = computed(() => store.getters.getMeetings);
    const isEmpty = computed(() => !filteredMeetings.value.length);

    const filteredMeetings = computed(() => {
      return meetings.value.filter((meeting) => {
        return areSameDate(dayjs(meeting.startDate), dayjs(selectedDate.value));
      });
    });

    return {
      filteredMeetings,
      isEmpty,
    };
  },
};
</script>

<style scoped lang="less">
.meeting-list {
  height: 30vh;
  overflow: scroll;
  padding-top: 5px;
  width: 100vw;
}

.meeting-item {
  margin: 5px;
}

.meeting-info {
  display: flex;
  justify-content: space-between;
}

.meeting-name {
  font: var(--font-heading-2);
  margin: 0 15px;
}

.meeting-location {
  font: var(--font-text-1);
  margin: 0 15px;
}
</style>
