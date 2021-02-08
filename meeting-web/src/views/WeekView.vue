<template>
  <View tabBar>
    <week-top />
    <week-left />
    <week-right :schedule="schedule" />
  </View>
</template>

<script>
import { computed } from "vue";

import { useStore } from "@/hooks/store";
import WeekLeft from "@/components/week/WeekLeft.vue";
import WeekTop from "@/components/week/WeekTop.vue";
import WeekRight from "@/components/week/WeekRight.vue";
import View from "@/components/common/View.vue";
export default {
  name: "WeekView",
  components: { WeekTop, WeekLeft, WeekRight, View },
  setup() {
    const store = useStore();
    const schedule = computed(() => store.getters["meeting/getMeetingsOfThisWeek"]);
    console.log(schedule)
    return {
      schedule,
    };
  },
};
</script>
