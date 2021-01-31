<template>
  <div>
    <calendar
      class="calendar"
      @confirm="handleSelect"
      :show-confirm="false"
      :poppable="false"
    ></calendar>
    <div></div>
  </div>
</template>

<script>
import { ref } from "vue";
import { Calendar } from "vant";

export default {
  name: "MonthView",
  components: { Calendar },
  setup() {
    const date = ref("");

    const handleSelect = (selectedDate) => {
      console.log("selectedDate: ", selectedDate);
    };

    return {
      date,
      handleSelect,
    };
  },
};
</script>

<style scoped>
.calendar {
  width: 100vw;
  height: 65vh;
}
</style>
