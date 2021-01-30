<template>
  <div class="right" :style="heightStyle">
    <div v-for="i of 12" :key="i" class="split" />
    <div class="schedule">
      <div v-for="(item, index) in schedule" :key="index" :style="getItemStyle(index)" class="schedule-item">shit{{ index }}</div>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue'
import dayjs from 'dayjs'
export default {
  name: 'WeekRight',
  props: {
    height: {
      type: String,
      default: '15rem',
    },
    schedule: {
      type: Array,
      required: true,
    },
  },
  setup(props) {
    const heightStyle = {
      height: props.height,
    }
    const schedule = ref(props.schedule)
    const colorArrays = ['#85B8CF', '#90C652', '#D8AA5A', '#FC9F9D', '#61BC69', '#12AEF3', '#E29AAD', '#ca90f4']
    const widthOfItem = 1
    const widthOfDay = 1.3
    const heightOfHour = 1.25
    const left = 1.15
    const top = 2.05
    const dayOfWeek = new dayjs().get('day')
    const getItemStyle = (index) => {
      const style = {}
      const item = schedule.value[index]
      const date1 = dayjs(item.startTime)
      const date2 = dayjs(item.endTime)
      let day = date1.get('day')
      if (day === 0) day = 7

      style.color = '#fff'
      if (day < dayOfWeek) style.backgroundColor = '#999999'
      else style.backgroundColor = colorArrays[index % colorArrays.length]

      style.width = widthOfItem + 'rem'

      let diffHours = date2.diff(date1) / 1000 / 3600
      style.height = heightOfHour * diffHours + 'rem'

      const hour = date1.get('hour')
      const minute = date1.get('minute')
      diffHours = (hour * 60 + minute - 7 * 60) / 60
      style.top = top + diffHours * heightOfHour + 'rem'

      style.left = left + (day - 1) * widthOfDay + 'rem'

      return style
    }

    return {
      heightStyle,
      // eslint-disable-next-line vue/no-dupe-keys
      schedule,
      getItemStyle,
    }
  },
}
</script>

<style lang="less" scoped>
.right {
  display: flex;
  flex-direction: column;
  justify-content: center;
  float: left;
  width: 330px;
  margin-top: 8px;
  margin-left: 8px;
  .split {
    height: 1px;
    border-top: 1px solid #ddd;
    flex: 1;
  }
  .schedule-item {
    position: absolute;
    font-size: 10px;
    border-radius: 5px;
  }
}
</style>
