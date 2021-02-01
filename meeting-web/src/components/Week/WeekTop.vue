<template>
  <div class="top">
    <div class="month">
      <div class="month-top">{{ dayOfMonth }}</div>
      <div class="month-bottom">月</div>
    </div>
    <div
      class="week"
      v-for="(item, index) in week"
      :key="item"
      :class="[index + 1 === dayOfWeek ? 'now-time' : 'other-time']"
    >
      <div class="week-top">周{{ item }}</div>
      <div class="week-bottom">{{ getDate(index) }}</div>
    </div>
  </div>
</template>

<script>
import { reactive, toRefs } from "vue";
import dayjs from "dayjs";
export default {
  name: "WeekTop",
  setup() {
    const now = new dayjs();
    const data = reactive({
      week: ["一", "二", "三", "四", "五", "六", "日"],
      dayOfWeek: now.get("day") === 0 ? 7 : now.get("day"),
      dayOfMonth: now.get("month") + 1,
      getDate: (index) => {
        return now.add(index - data.dayOfWeek + 1, "day").format("MM/DD");
      },
    });

    return {
      ...toRefs(data),
    };
  },
};
</script>

<style lang="less" scope>
.top {
  padding: 8px 0;
  margin-bottom: 12px;
  display: flex;
  justify-content: center;
  background-color: var(--colors-week-background-default);
  color: var(--colors-medium);
  font-size: 14px;
  font-weight: 600;
  text-align: center;
  .month {
    flex: 0.8;
    display: flex;
    flex-direction: column;
    margin-left: 8px;
    margin-right: 3px;
    .month-bottom {
      font-weight: 500;
      margin-top: 7px;
      font-size: 14px;
    }
  }
  .week {
    border-radius: 6px;
    flex: 1;
    display: flex;
    flex-direction: column;
    margin-right: 8px;
    .week-bottom {
      font-weight: 550;
      margin-top: 7px;
      font-size: 8px;
    }
  }

  .now-time {
    background-color: var(--colors-week-background-today);
  }

  .other-time {
    background-color: var(--colors-week-background-default);
  }
}
</style>
