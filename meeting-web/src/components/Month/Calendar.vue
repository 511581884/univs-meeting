<template>
  <vant-calendar
    class="calendar"
    ref="calendarRef"
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
import { computed, onMounted, ref, watch } from "vue";
import { useStore } from "vuex";
import dayjs from "dayjs";

import { Calendar as VantCalendar } from "vant";

export default {
  components: { VantCalendar },
  name: "Calendar",
  props: ["selectedDate"],
  setup(props, context) {
    const store = useStore();
    const datesHaveMeeting = computed(() => store.getters.datesHaveMeeting);
    const minDate = ref(
      dayjs()
        .subtract(3, "months")
        .toDate()
    );
    const calendarRef = ref(null);
    const selectedDate = computed(() => props.selectedDate);
    watch(selectedDate, () => {
      calendarRef.value.reset(selectedDate.value);
    });

    onMounted(() => {
      document
        .querySelector(".van-calendar__header-subtitle")
        .addEventListener("click", () => {
          context.emit("clickTitle");
        });
    });

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
      calendarRef,
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
.van-calendar__header-subtitle {
  cursor: pointer;
}
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
