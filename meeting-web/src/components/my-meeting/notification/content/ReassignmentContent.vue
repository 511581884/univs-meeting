<template>
  <p>
    {{ `  ${requester} 请求您代其出席会议` }}
  </p>
</template>

<script>
import { computed } from "vue";

export default {
  name: "ReassignmentContent",
  props: ["notification"],
  setup(props) {
    const requester = computed(() => props.notification.requesterName);

    return {
      requester,
    };
  },
};
</script>
