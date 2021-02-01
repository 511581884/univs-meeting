<template>
  <vant-calendar
    class="calendar"
    @confirm="onConfirm"
    :show-title="false"
    :show-confirm="false"
    :poppable="false"
    :row-height="60"
    :formatter="formatter"
  ></vant-calendar>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";

import { Calendar as VantCalendar } from "vant";

export default {
  name: "Calendar",
  components: { VantCalendar },
  setup(_, context) {
    const store = useStore();
    const datesHaveMeeting = computed(() => store.getters.datesHaveMeeting);

    const onConfirm = (date) => {
      context.emit("selectDate", date);
    };

    const formatter = (day) => {
      const calendarMonth = day.date.getMonth();
      const calendarDate = day.date.getDate();

      datesHaveMeeting.value.forEach((date) => {
        if (
          calendarMonth === date.getMonth() &&
          calendarDate === date.getDate()
        )
          day.bottomInfo = "__";
      });
      return day;
    };

    return {
      onConfirm,
      formatter,
    };
  },
};
</script>

<style scoped>
.calendar {
  height: 60vh;
  width: 100vw;
}
</style>

<style>
.van-calendar__bottom-info {
  color: var(--colors-orange);
  font-weight: 900;
  font-size: 0.35rem;
  transform: translateY(-1vh);
}

.van-calendar__selected-day {
  background-color: var(--colors-primary);
}
</style>
