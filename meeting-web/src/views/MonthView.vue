<template>
  <div class="container">
    <calendar @selectDate="handleDateSelect"></calendar>
    <shadow-separator></shadow-separator>
    <meeting-list :selectedDate="selectedDate"></meeting-list>
    <date-picker :show="pickerOpened" :selectdDate="selectedDate"></date-picker>
  </div>
</template>

<script>
import { ref } from "vue";

import Calendar from "../components/month/Calendar";
import MeetingList from "../components/month/MeetingList";
import ShadowSeparator from "../components/month/ShadowSeparator";
import DatePicker from "../components/month/DatePicker";

export default {
  name: "MonthView",
  components: { Calendar, MeetingList, ShadowSeparator, DatePicker },
  setup() {
    const selectedDate = ref(new Date());
    const pickerOpened = ref(true);

    const handleDateSelect = (date) => {
      selectedDate.value = date;
    };

    return {
      selectedDate,
      handleDateSelect,
      pickerOpened,
    };
  },
};
</script>

<style scoped>
.container {
  position: relative;
}
</style>
