<template>
  <p>
    {{ `${dateTime} ${location}` }}
  </p>
</template>

<script>
import { computed } from "vue";

import { formatDate } from "@/helpers/dateTime";
export default {
  name: "RegularContent",
  props: ["notification"],
  setup(props) {
    const dateTime = computed(() => formatDate(props.notification.startDate));
    const location = computed(() => props.notification.location);

    return {
      dateTime,
      location,
    };
  },
};
</script>
