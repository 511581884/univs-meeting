<template>
  <van-cell-group>
    <van-cell v-for="(item, index) in attendees" :key="index">
      <template #title>
        <span class="custom-title">{{ item.name }}</span>
        <van-tag type="success" v-if="item.isGuest === 1" class="tag">校外嘉宾</van-tag>
      </template>
      <template #label>
        <span class="custom-title">{{ item.dept }}</span>
      </template>
      <template #right-icon>
        <van-icon name="phone-circle" @click="call(item.phone)" />
      </template>
    </van-cell>
  </van-cell-group>
</template>

<script>
const attendees = [
  { name: '赵老六', dept: 'XX公司', phone: '5236522', isGuest: 1 },
  { name: '王老五', dept: '学工部', phone: '5236522', isGuest: 0 },
  { name: '张三三', dept: '科发院', phone: '5236522', isGuest: 0 },
  { name: '李四四', dept: '人事处', phone: '5236522', isGuest: 0 },
]
import {} from 'vue'
export default {
  name: 'AttendeesView',
  setup() {
    const call = (phone) => {
      window.location.href = `tel:${phone}`
    }
    return {
      attendees,
      call,
    }
  },
}
</script>

<style lang="less">
.van-cell-group {
  .van-cell {
    .van-cell__title {
      .tag {
        position: relative;
        left: 10px;
      }
    }
    .van-icon {
      font-size: 40px;
      right: 5px;
    }
  }
}
</style>