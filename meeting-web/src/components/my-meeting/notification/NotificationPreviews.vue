<template>
  <div class="container">
    <div class="heading-container">
      <linked-cell routeName="NotificationCenter" label="我的通知" />
    </div>
    <notification-list :notifications="notifications" />
  </div>
</template>

<script>
import { computed } from "vue";

import { useStore } from "@/hooks/store";
import LinkedCell from "../../common/LinkedCell";
import NotificationList from "./NotificationList";

export default {
  components: { NotificationList, LinkedCell },
  name: "NotificationPreviews",
  setup() {
    const store = useStore();
    const notifications = computed(
      () => store.getters["notification/getTopThreeNotifications"]
    );

    return {
      notifications,
    };
  },
};
</script>

<style scoped>
.container {
  height: 36vh;
  margin-bottom: 10px;
  box-shadow: 0px 2px 1px -1px rgba(0, 0, 0, 0.2),
    0px 1px 1px 0px rgba(0, 0, 0, 0.14), 0px 1px 3px 0px rgba(0, 0, 0, 0.12);
}

.heading-container {
  height: 5vh;
  /* background-color: red; */
  padding: 5px;
  display: flex;
  align-items: center;
}

.heading {
  margin: 0;
  margin-left: 30px;
  font: var(--font-heading-1);
}
</style>
