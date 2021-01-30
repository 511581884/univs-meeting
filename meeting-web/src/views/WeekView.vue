<template>
  <week-top/>
  <week-left/>
  <week-right :schedule="schedule"/>
</template>

<script>
import WeekLeft from '@/components/week/WeekLeft.vue';
import WeekTop from '@/components/week/WeekTop.vue';
import WeekRight from '@/components/week/WeekRight'
const schedule = [
  { startTime: '2021-01-25 07:00', endTime: '2021-01-25 09:00' },
  { startTime: '2021-01-27 07:50', endTime: '2021-01-27 09:40' },
  { startTime: '2021-01-28 07:00', endTime: '2021-01-28 08:00' },
  { startTime: '2021-01-28 14:00', endTime: '2021-01-28 15:30' },
  { startTime: '2021-01-28 09:00', endTime: '2021-01-28 10:30' },
  { startTime: '2021-01-29 08:30', endTime: '2021-01-29 10:30' },
  { startTime: '2021-01-29 14:30', endTime: '2021-01-29 16:45' },
  { startTime: '2021-01-30 14:30', endTime: '2021-01-30 16:45' },
  { startTime: '2021-01-30 17:30', endTime: '2021-01-30 18:00' },
  { startTime: '2021-01-31 15:30', endTime: '2021-01-31 18:05' },
]
export default {
  name: 'WeekView',
  components: { WeekTop, WeekLeft, WeekRight },
  setup() {
    return {
      schedule
    }
    
  }
}
</script>
