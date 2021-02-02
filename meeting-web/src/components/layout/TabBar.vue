// TabBar: 底部导航栏
<template>
  <vant-tabbar route>
    <vant-tabbar-item replace to="/week" icon="calendar-o"
      >周视图</vant-tabbar-item
    >
    <vant-tabbar-item replace to="/month" icon="notes-o"
      >月视图</vant-tabbar-item
    >
    <vant-tabbar-item replace to="/me" icon="user-o">我的会议</vant-tabbar-item>
  </vant-tabbar>
</template>

<script>
import { Tabbar as VantTabbar, TabbarItem as VantTabbarItem } from "vant";

export default {
  name: "TabBar",
  components: { VantTabbar, VantTabbarItem },
  setup() {
    return {};
  },
};
</script>

<style scoped></style>
