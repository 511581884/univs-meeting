<template>
  <p>
    <span class="previous-content">【{{ label }}】</span
    ><span>{{ meetingName }}</span>
  </p>
</template>

<script>
import { computed } from "vue";
const LABELS = {
  cancel: "会议取消",
  change: "会议变更",
  reassign: "改派请求",
  remind: "会议提醒",
};

export default {
  name: "BasicContent",
  props: ["type", "meetingName"],
  setup(props) {
    const label = computed(() => LABELS[props.type]);
    return {
      label,
    };
  },
};
</script>

<style scoped>
.previous-content {
  margin-right: 4px;
}
</style>
