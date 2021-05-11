<template>
  <View navBar navBarTitle="通知中心">
    <div class="history-item">
      <list-header>待确认</list-header>
      <notification-list
        :notifications="unconfirmed"
        :class="'history-unconfirmed'"
      />
    </div>
    <div class="history-item" v-for="key in Object.keys(regular)" :key="key">
      <list-header>{{ getDate(key) }}</list-header>
      <notification-list :notifications="regular[key]" />
    </div>
  </View>
</template>

<script>
import { computed, onUnmounted } from "vue";

import { useStore } from "@/hooks/store";
import View from "../components/common/View.vue";
import NotificationList from "../components/my-meeting/notification/NotificationList.vue";
import ListHeader from "@/components/common/ListHeader.vue";
import { formatDate } from "../helpers/dateTime";

export default {
  name: "NotificationCenterView",
  components: { View, NotificationList, ListHeader },
  setup() {
    const store = useStore();
    const categorized = computed(
      () => store.getters["notification/getCategorizedByDate"]
    );
    const unconfirmed = computed(() => categorized.value.unconfirmed);
    const regular = computed(() => {
      const copy = categorized.value;
      delete copy.unconfirmed;
      return copy;
    });

    const getDate = (dateString) => {
      return formatDate(new Date(dateString), false);
    };

    onUnmounted(() => {
      store.dispatch("notification/makeAllRead");
    });

    return {
      unconfirmed,
      regular,
      getDate,
    };
  },
};
</script>

<style scoped>
.history-header {
  background-color: var(--colors-light);
  margin: 2px 0;
  font: var(--font-heading-2);
  padding: 2px;
  padding-left: 20px;
}

.history-unconfirmed {
  color: red;
}
</style>
