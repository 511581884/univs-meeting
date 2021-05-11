<template>
  <div class="right" :style="heightStyle">
    <div v-for="i of 12" :key="i" class="split" />
    <div class="schedule">
      <div v-for="(item, index) in schedule" :key="item.id" :style="getItemStyle(index)" class="schedule-item" @click="goTo('Details',item.id)">
        <span>{{ item.name }}</span>
      </div>
    </div>
  </div>
</template>

<script>
import dayjs from 'dayjs'
import { useRouter } from 'vue-router'
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

    // eslint-disable-next-line vue/no-setup-props-destructure
    const schedule = props.schedule
    const colorArrays = ['#85B8CF', '#90C652', '#D8AA5A', '#FC9F9D', '#61BC69', '#12AEF3', '#E29AAD', '#ca90f4']
    const widthOfItem = 1
    const widthOfDay = 1.26
    const heightOfHour = 1.25
    const left = 1.15
    const top = 2.05
    let dayOfWeek = new dayjs().get('day')
    if (dayOfWeek === 0) dayOfWeek = 7
    const getItemStyle = (index) => {
      const style = {}
      const item = schedule[index]
      const date1 = dayjs(item.startDate)
      const date2 = dayjs(item.endDate)
      let day = date1.get('day') === 0 ? 7 : date1.get('day')

      style.color = 'var(--colors-white)'
      if (day < dayOfWeek) style.backgroundColor = 'var(--colors-week-background-past)'
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

    const router = useRouter()
    const goTo = (name, meetingId) => {
      router.push({
        name,
        params:{ meetingId }
      })
    }
      
    return {
      heightStyle,
      // eslint-disable-next-line vue/no-dupe-keys
      schedule,
      getItemStyle,
      goTo
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
    font-size: 11px;
    border-radius: 5px;
    text-align: center;
    /*
    文字垂直居中，很丑
    display: table;
    span {
      display: table-cell;
      vertical-align: middle;
    }
    */
  }
}
</style>
