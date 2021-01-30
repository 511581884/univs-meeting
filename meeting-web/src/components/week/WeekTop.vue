<template>
  <div class="top">
    <div class="month">
      <div class="month-top">{{ now.get('month') + 1 }}</div>
      <div class="month-bottom">月</div>
    </div>
    <div class="week" v-for="(item, index) in week" :key="item" :style="{ backgroundColor: index + 1 === dayOfWeek ? '#dbe4eb' : '#fcfcfc' }">
      <div class="week-top">周{{ item }}</div>
      <div class="week-bottom">{{ getDate(index) }}</div>
    </div>
  </div>
</template>

<script>
import {reactive } from 'vue'
import dayjs from 'dayjs'
export default {
  name: 'WeekTop',
  setup() {
    const data = reactive({
      week: ['一', '二', '三', '四', '五', '六', '日'],
      now: new dayjs(),
      dayOfWeek: now.get('day'),
      getDate = (index) => {
        return now.add(index - dayOfWeek + 1, 'day').format('MM/DD')
      }
    })
    return {
      ...toRefs(data)
    }
  },
}
</script>

<style lang="less">
</style>