<template>
  <div class="meeting-info" @click="onClick(meeting.id)">
    <div class="container-left">
      <h4 class="meeting-name">{{ meeting.name }}</h4>
      <h5 class="meeting-location">{{ meeting.location }}</h5>
    </div>
    <meeting-time
      :startDate="meeting.startDate"
      :endDate="meeting.endDate"
    ></meeting-time>
  </div>
  <separator v-if="separator" />
</template>

<script lang="ts">
import MeetingTime from "./MeetingTime.vue";
import Separator from "../common/Separator.vue";

export default {
  name: "MeetingItem",
  components: { MeetingTime, Separator },
  props: ["meeting", "separator"],
  emits: ["meetingClick"],
  setup(_, context) {
    const onClick = (id) => {
      context.emit("meetingClick", id);
    };

    return {
      onClick,
    };
  },
};
</script>

<style scoped>
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
