<template>
  <View navBar navBarTitle="通知中心">
    <div class="history-item">
      <h3 class="history-header">待确认</h3>
      <notification-list
        :notifications="unconfirmed"
        :class="'history-unconfirmed'"
      />
    </div>
    <div class="history-item" v-for="key in Object.keys(regular)" :key="key">
      <h3 class="history-header">{{ getDate(key) }}</h3>
      <notification-list :notifications="regular[key]" />
    </div>
  </View>
</template>

<script>
import { computed } from "vue";
import { useStore } from "vuex";

import View from "../components/common/View";
import NotificationList from "../components/my-meeting/notification/NotificationList";
import { formatDate } from "../helpers/dateTime";

export default {
  name: "NotificationCenterView",
  components: { View, NotificationList },
  setup() {
    const store = useStore();
    const categorized = computed(() => store.getters.getCategorizedByDate);
    const unconfirmed = computed(() => categorized.value.unconfirmed);
    const regular = computed(() => {
      const copy = categorized.value;
      delete copy.unconfirmed;
      return copy;
    });

    const getDate = (dateString) => {
      return formatDate(new Date(dateString), false);
    };

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
