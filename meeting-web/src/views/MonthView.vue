/* eslint-disable vue/no-unused-components */
<template>
  <View tabBar>
    <div class="container">
      <calendar
        :selectedDate="selectedDate"
        @selectDate="handleDateSelect"
        @clickTitle="handlePickerOpen"
      ></calendar>
      <meeting-list :meetings="filtered" />
      <date-picker
        :show="pickerOpened"
        @confirm="handlePickerConfirm"
      ></date-picker>
    </div>
  </View>
</template>

<script lang="ts">
import { computed, ref } from "vue";

import View from "../components/common/View.vue";
import Calendar from "../components/month/Calendar.vue";
import MeetingList from "../components/meeting/MeetingList.vue";
import DatePicker from "../components/month/DatePicker.vue";
import { useMeetings } from "@/hooks/store";
import { areSameDate } from "@/helpers/dateTime";

export default {
  name: "MonthView",
  components: { Calendar, MeetingList, DatePicker, View },
  setup() {
    const pickerOpened = ref(false);
    const selectedDate = ref(new Date());
    const meetings = useMeetings();

    const filterMeetingByDate = () => {
      return meetings.value.filter((meeting) =>
        areSameDate(meeting.startDate, selectedDate.value)
      );
    };
    const filtered = computed(filterMeetingByDate);

    const isEmpty = computed(() => !filtered.value.length);

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
      filtered,
      handleDateSelect,
      handlePickerConfirm,
      handlePickerOpen,
      isEmpty,
      pickerOpened,
      selectedDate,
    };
  },
};
</script>

<style scoped>
.container {
  position: relative;
}
</style>
