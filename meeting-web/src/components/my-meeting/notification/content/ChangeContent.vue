<template>
  <p>
    <span class="previous-content">由</span
    ><span class="following-content-original"
      >{{ `${original.dateTime} ${original.location}` }}
    </span>
  </p>
  <p>
    <span class="previous-content">变更为</span>
    <span class="following-content-current">
      {{ `${current.dateTime} ${current.location}` }}
    </span>
  </p>
</template>

<script>
import { computed, reactive } from "vue";

import { formatDate } from "@/helpers/dateTime";

export default {
  name: "ChangeContent",
  props: ["notification"],
  setup(props) {
    const notification = computed(() => props.notification);
    const current = reactive({ dateTime: "", location: "" });
    const original = reactive({ dateTime: "", location: "" });

    current.dateTime = formatDate(notification.value.currentDate);
    current.location = notification.value.currentLocation;
    original.dateTime = formatDate(notification.value.originalDate);
    original.location = notification.value.originalLocation;

    return {
      original,
      current,
    };
  },
};
</script>

<style scoped>
.previous-content {
  display: inline-block;
  width: 60px;
  margin-right: 5px;
}
.following-content-original {
  color: var(--colors-medium);
  text-decoration: line-through;
}
</style>
