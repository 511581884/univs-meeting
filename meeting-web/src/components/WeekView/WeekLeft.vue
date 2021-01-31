<template>
  <div class="left" :style="heightStyle">
    <div v-for="item in time" :key="item" class="left-item">
      {{ item }}
    </div>
  </div>
</template>

<script>
export default {
  name: 'WeekLeft',
  props: {
    height: {
      type: String,
      default: '15rem',
    },
  },
  setup(props) {
    const time = ['07:00', '08:00', '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00', '16:00', '17:00', '18:00']

    const heightStyle = {
      height: props.height,
    }

    return {
      time,
      heightStyle,
    }
  },
}
</script>

<style lang="less" scoped>
.left {
  width: 30px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin-left: 5px;
  text-align: center;
  float: left;
  .left-item {
    flex: 1;
    color: var(--colors-text-medium);
    font-size: 14px;
  }
}
</style>
