<template>
  <div class="meeting-list">
    <div
      class="meeting-item"
      v-for="(meeting, index) in filteredMeetings"
      :key="meeting.id"
    >
      <meeting-time
        :startDate="meeting.startDate"
        :endDate="meeting.endDate"
      ></meeting-time>
      <div class="container-left">
        <h4 class="meeting-name">{{ meeting.name }}</h4>
        <h5 class="meeting-location">{{ meeting.location }}</h5>
      </div>
      <separator v-if="index !== filteredMeetings.length - 1"></separator>
    </div>
  </div>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";
import dayjs from "dayjs";

import Separator from "../common/Separator";
import MeetingTime from "./MeetingTime";

export default {
  components: { MeetingTime, Separator },
  name: "MeetingList",
  props: ["selectedDate"],
  setup(props) {
    const store = useStore();
    const selectedDate = computed(() => props.selectedDate);
    const meetings = computed(() => store.state.meetings);

    const areSameDate = (date1, date2) => {
      return (
        date1.year() === date2.year() &&
        date1.month() === date2.month() &&
        date1.date() === date2.date()
      );
    };

    const filteredMeetings = computed(() => {
      return meetings.value.filter((meeting) => {
        return areSameDate(dayjs(meeting.startDate), dayjs(selectedDate.value));
      });
    });

    return {
      filteredMeetings,
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
  margin: 5px 0;
  * {
    cursor: pointer;
  }
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
