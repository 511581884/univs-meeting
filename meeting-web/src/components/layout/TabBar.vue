// TabBar: 底部导航栏
<template>
  <vant-tabbar route>
    <vant-tabbar-item replace to="/week" icon="calendar-o"
      >周视图</vant-tabbar-item
    >
    <vant-tabbar-item replace to="/month" icon="notes-o"
      >月视图</vant-tabbar-item
    >
    <vant-tabbar-item replace to="/me" icon="user-o">
      <badge :content="unreadNotificationAmount" />
      我的会议
    </vant-tabbar-item>
  </vant-tabbar>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";

import { Tabbar as VantTabbar, TabbarItem as VantTabbarItem } from "vant";
import Badge from "../common/Badge.vue";

export default {
  name: "TabBar",
  components: { VantTabbar, VantTabbarItem, Badge },
  setup() {
    const store = useStore();
    const unreadNotificationAmount = computed(
      () => store.getters["notification/getUnreadAmount"]
    );

    return {
      unreadNotificationAmount,
    };
  },
};
</script>

<style scoped>
.badge {
  background-color: red;
}
</style>
