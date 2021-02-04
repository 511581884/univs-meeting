<template>
  <vant-steps direction="vertical" class="notification-list" :active="-1">
    <notification-item
      v-for="notification in notifications"
      :key="notification.id"
      :notification="notification"
    />
  </vant-steps>
</template>

<script>
import { Steps as VantSteps } from "vant";
import NotificationItem from "./NotificationItem";

export default {
  name: "NotificationList",
  components: { NotificationItem, VantSteps },
  props: ["notifications"],
};
</script>

<style scoped>
.notification-list {
  padding-left: 40px;
}
</style>
