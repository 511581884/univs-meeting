<template>
  <vant-calendar
    class="calendar"
    @confirm="onConfirm"
    :show-confirm="false"
    :poppable="false"
  ></vant-calendar>
</template>

<script>
import { Calendar as VantCalendar } from "vant";
export default {
  name: "Calendar",
  components: { VantCalendar },
  setup(_, context) {
    const onConfirm = (date) => {
      context.emit("selectDate", date);
    };
    return {
      onConfirm,
    };
  },
};
</script>

<style scoped>
.calendar {
  width: 100vw;
  height: 60vh;
}
</style>
