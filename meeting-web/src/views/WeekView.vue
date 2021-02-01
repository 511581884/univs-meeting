<template>
  <week-top />
  <week-left />
  <week-right :schedule="schedule" />
</template>

<script>
import WeekLeft from '@/components/Week/WeekLeft.vue'
import WeekTop from '@/components/Week/WeekTop.vue'
import WeekRight from '@/components/Week/WeekRight.vue'
import { computed } from 'vue'
import { useStore } from 'vuex'
export default {
  name: 'WeekView',
  components: { WeekTop, WeekLeft, WeekRight },
  setup() {
    const store = useStore()
    const schedule = computed( ()=> store.state.meetings)
    return {
      schedule
    }
  },
}
</script>
