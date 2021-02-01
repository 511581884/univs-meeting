<template>
  <div class="container">
    <calendar
      :selectedDate="selectedDate"
      @selectDate="handleDateSelect"
      @clickTitle="handlePickerOpen"
    ></calendar>
    <shadow-separator></shadow-separator>
    <meeting-list :selectedDate="selectedDate"></meeting-list>
    <date-picker
      :show="pickerOpened"
      :selectdDate="selectedDate"
      @confirm="handlePickerConfirm"
    ></date-picker>
  </div>
</template>

<script>
import { ref } from "vue";

<<<<<<< HEAD
import Calendar from "../components/month/Calendar";
import MeetingList from "../components/month/MeetingList";
import ShadowSeparator from "../components/month/ShadowSeparator";
import DatePicker from "../components/month/DatePicker";
=======
import Calendar from "../components/Month/Calendar";
import MeetingList from "../components/Month/MeetingList";
import ShadowSeparator from "../components/Month/ShadowSeparator";
>>>>>>> 17dd310ec07cc1db03117343c2549e7dbfc97e7d

export default {
  name: "MonthView",
  components: { Calendar, MeetingList, ShadowSeparator, DatePicker },
  setup() {
    const selectedDate = ref(new Date());
    const pickerOpened = ref(false);

    const handleDateSelect = (date) => {
      selectedDate.value = date;
    };

    const handlePickerOpen = () => {
      pickerOpened.value = true;
    };

    const handlePickerConfirm = (date) => {
      selectedDate.value = date;
      pickerOpened.value = false;
    };

    return {
      selectedDate,
      handleDateSelect,
      handlePickerConfirm,
      handlePickerOpen,
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
