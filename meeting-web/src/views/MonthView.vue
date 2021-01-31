<template>
  <div>
    <calendar @selectDate="handleDateSelect"></calendar>
    <meeting-list :selectedDate="selectedDate"></meeting-list>
  </div>
</template>

<script>
import { ref } from "vue";

import Calendar from "../components/Month/Calendar";
import MeetingList from "../components/Month/MeetingList";

export default {
  name: "MonthView",
  components: { Calendar, MeetingList },
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
