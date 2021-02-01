<template>
  <div class="container">
    <calendar @selectDate="handleDateSelect"></calendar>
    <shadow-separator></shadow-separator>
    <meeting-list :selectedDate="selectedDate"></meeting-list>
  </div>
</template>

<script>
import { ref } from "vue";

import Calendar from "../components/Month/Calendar";
import MeetingList from "../components/Month/MeetingList";
import ShadowSeparator from "../components/Month/ShadowSeparator";

export default {
  name: "MonthView",
  components: { Calendar, MeetingList, ShadowSeparator },
  setup() {
    const selectedDate = ref();

    const handleDateSelect = (date) => {
      selectedDate.value = date;
    };

    return {
      selectedDate,
      handleDateSelect,
    };
  },
};
</script>

<style scoped>
.container {
  position: relative;
}
</style>
