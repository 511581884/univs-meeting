<template>
  <div class="container-right">
    <h5 class="meeting-time">
      {{ `${startHour}:${startMinute}` }}
    </h5>
    <h5 class="meeting-time">
      {{ `${endHour}:${endMinute}` }}
    </h5>
  </div>
</template>

<script>
import { computed } from "vue";

import { formatTime } from "@/helpers/dateTime";
export default {
  name: "MeetingTime",
  props: ["startDate", "endDate"],
  setup(props) {
    const startHour = computed(() => formatTime(props.startDate.getHours()));
    const startMinute = computed(() =>
      formatTime(props.startDate.getMinutes())
    );
    const endHour = computed(() => formatTime(props.endDate.getHours()));
    const endMinute = computed(() => formatTime(props.endDate.getMinutes()));

    return {
      endHour,
      endMinute,
      startHour,
      startMinute,
    };
  },
};
</script>

<style scoped>
.meeting-time {
  font: var(--font-heading-3);
  margin: 0px;
  margin-right: 15px;
}
</style>
