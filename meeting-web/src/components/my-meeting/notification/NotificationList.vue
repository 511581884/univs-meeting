<template>
  <vant-steps direction="vertical" class="notification-list" :active="-1">
    <notification-item notificationType="cancel"></notification-item>
    <notification-item notificationType="remind"></notification-item>
    <notification-item notificationType="change"></notification-item>
  </vant-steps>
</template>

<script>
import { Steps as VantSteps } from "vant";
import NotificationItem from "./NotificationItem";

export default {
  name: "NotificationList",
  components: { NotificationItem, VantSteps },
  setup() {
    return {};
  },
};
</script>

<style scoped>
.notification-list {
  padding-left: 40px;
}
</style>
