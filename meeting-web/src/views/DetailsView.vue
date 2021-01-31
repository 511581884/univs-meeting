<template>
  <div class="header">
    <div class="header-top">
      <div class="title">{{ details.subject }}</div>
      <div class="host">—— 主持人：{{ details.host }} ——</div>
    </div>
    <div class="header-bottom">
      <div class="time">
        <van-icon name="clock-o" />
        <span>{{ getTime(details.begin_time, details.end_time) }}</span>
      </div>
      <div class="location">
        <van-icon name="location-o" />
        <span>{{ details.room_name }}</span>
      </div>
    </div>
  </div>
  <div class="body">
    <van-cell-group>
      <van-cell title="参会人员" is-link />
      <van-cell title="会议文件" is-link @click="clickFilesCell" :arrow-direction="filesCellArrowDirection" />
      <transition name="files-open">
        <div v-if="isBrowseFiles" class="files">
          <van-cell v-for="(item, index) in details.files" :key="index" :title="item.name" is-link icon="orders-o" />
        </div>
      </transition>
      <van-cell title="会后反馈" is-link />
    </van-cell-group>
    <div class="btns">
      <van-button class="join">参会</van-button>
      <van-button class="leave">请假</van-button>
      <van-button class="reassign">代会</van-button>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue'
import dayjs from 'dayjs'
const details = {
  subject: '优秀辅导员表彰大会',
  host: '王世杰',
  begin_time: '2021-01-31 14:00',
  end_time: '2021-01-31 16:30',
  room_name: '会议中心 103会议室',
  files: [{ name: '学习雷锋好榜样' }, { name: '辅导员表彰大会名单' }],
}
export default {
  name: 'DetailsView',
  setup() {
    const getTime = (bt, et) => {
      bt = new dayjs(bt)
      et = new dayjs(et)
      const week = ['日', '一', '二', '三', '四', '五', '六']
      const dayOfWeek = '星期' + week[bt.get('day')]
      const _bt = bt.format('HH:mm')
      const _et = et.format('HH:mm')
      const _t = bt.format('YYYY年MM月DD日')
      return `${_t} ${dayOfWeek} ${_bt}~${_et}`
    }

    const isBrowseFiles = ref(false)
    const filesCellArrowDirection = ref('')
    const clickFilesCell = () => {
      isBrowseFiles.value = !isBrowseFiles.value
      filesCellArrowDirection.value = isBrowseFiles.value ? 'down' : ''
    }

    return {
      details,
      getTime,
      isBrowseFiles,
      filesCellArrowDirection,
      clickFilesCell,
    }
  },
}
</script>

<style lang="less" scoped>
.header {
  background-image: url(../assets/imgs/DetailsBG.png);
  height: 280px;
  width: 100%;
  -moz-background-size: 100% 100%;
  background-size: 100% 100%;
  color: var(--colors-text-white);
  font: var(--font-text-1);
  .header-top {
    text-align: center;
    padding-top: 90px;
    .title {
      font: var(--font-heading-1);
      font-size: 28px;
    }
    .host {
      margin-top: 15px;
      font-size: 13px;
    }
  }
  .header-bottom {
    text-align: center;
    padding-top: 30px;
    font-size: 14px;
    .van-icon {
      position: relative;
      top: 2px;
      right: 3px;
    }
    .location {
      margin-top: 8px;
      position: relative;
      left: -54px;
    }
  }
}
.body {
  font: var(--font-text-1);

  .btns {
    //position: fixed;
    margin-top: 30px;
    button {
      height: 100px;
      width: 100px;
      border-radius: 50%;
      margin: 0 12px;
      font-size: 18px;
      color: var(--colors-text-white);
    }
    .join {
      background-color: var(--colors-details-btn-green);
      border: 1px solid var(--colors-details-btn-green);
    }
    .leave {
      background-color: var(--colors-details-btn-red);
      border: 1px solid var(--colors-details-btn-red);
    }
    .reassign {
      background-color: var(--colors-details-btn-orange);
      border: 1px solid var(--colors-details-btn-orange);
    }
  }
}

.files-open-enter-active {
  animation: files 0.3s;
}
.files-open-leave-active {
  animation: files 0.3s reverse;
}
@keyframes files {
  from {
    transform: scaleY(0.1);
  }
  to {
    transform: scaleY(1);
  }
}
</style>