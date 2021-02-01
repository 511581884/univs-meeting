<template>
  <vant-calendar
    class="calendar"
    @confirm="onConfirm"
    :show-title="false"
    :show-confirm="false"
    :poppable="false"
    :row-height="60"
    :formatter="formatter"
    :minDate="minDate"
  ></vant-calendar>
</template>

<script>
import { computed, ref } from "vue";
import { useStore } from "vuex";

import { Calendar as VantCalendar } from "vant";

export default {
  name: "Calendar",
  components: { VantCalendar },
  setup(_, context) {
    const store = useStore();
    const datesHaveMeeting = computed(() => store.getters.datesHaveMeeting);
    const minDate = ref(new Date(new Date().getFullYear() - 1, 0, 1));

    const onConfirm = (date) => {
      context.emit("selectDate", date);
    };

    const isDateBeforeToday = (date) => {
      const today = new Date();
      return (
        date.getFullYear() < today.getFullYear() ||
        date.getMonth() < today.getMonth() ||
        date.getDate() < today.getDate()
      );
    };

    const formatter = (day) => {
      const calendarMonth = day.date.getMonth();
      const calendarDate = day.date.getDate();

      if (isDateBeforeToday(day.date)) {
        day.className = "disable-date";
      }

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
      minDate,
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

.disable-date {
  color: var(--colors-medium);
}
</style>
