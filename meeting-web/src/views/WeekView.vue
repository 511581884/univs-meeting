<template>
  <week-top />
  <week-left />
  <week-right :schedule="schedule" />
  <tab-bar></tab-bar>
</template>

<script>
import WeekLeft from "@/components/week/WeekLeft.vue";
import WeekTop from "@/components/week/WeekTop.vue";
import WeekRight from "@/components/week/WeekRight.vue";
import { computed } from "vue";
import { useStore } from "vuex";
import TabBar from "@/components/layout/TabBar.vue";
export default {
  name: "WeekView",
  components: { WeekTop, WeekLeft, WeekRight, TabBar },
  setup() {
    const store = useStore();
    const schedule = computed(() => store.state.meetings);
    return {
      schedule,
    };
  },
};
</script>
