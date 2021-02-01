<template>
<div class="header">
    <div class="header-top">
      <div class="title">{{ details.name }}</div>
      <div class="host">—— 主持人：{{ details.host }} ——</div>
    </div>
    <div class="header-bottom">
      <div class="time">
        <van-icon name="clock-o" />
        <span>{{ getTime(details.startDate, details.endDate) }}</span>
      </div>
      <div class="location">
        <van-icon name="location-o" />
        <span>{{ details.location }}</span>
      </div>
    </div>
  </div>
</template>

<script>
import dayjs from "dayjs";
import { Icon as VanIcon } from "vant";
export default {
  name: 'MeetingInfo',
  props: {
    details: {
      type: Object,
      required: true
    }
  },
  components: { VanIcon },
  setup() {
    /* 会议时间信息的处理函数，参数分别为开始时间和结束时间  */
    const getTime = (bt, et) => {
      bt = new dayjs(bt);
      et = new dayjs(et);
      const week = ["日", "一", "二", "三", "四", "五", "六"];
      const dayOfWeek = "星期" + week[bt.get("day")];
      const _bt = bt.format("HH:mm");
      const _et = et.format("HH:mm");
      const _t = bt.format("YYYY年MM月DD日");
      return `${_t} ${dayOfWeek} ${_bt}~${_et}`;
    };

    return {
      getTime
    }
  }
}
</script>


<style lang="less" scoped>
.header {
  background-image: url(../../assets/images/DetailsBG.png);
  height: 280px;
  width: 100%;
  -moz-background-size: 100% 100%;
  background-size: 100% 100%;
  color: var(--colors-white);
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
    padding-top: 30px;
    font-size: 14px;
    position: relative;
    left: 50px;
    width: 300px;
    .van-icon {
      position: relative;
      top: 2px;
      margin-right: 5px;
    }
    .time {
      margin-bottom: 5px;
    }
  }
}
</style>