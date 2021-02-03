<template>
  <vant-step class="notification-item" :class="styleObject">
    <p class="notification-content">【到会提醒】学校优秀辅导员座谈会</p>
    <p class="notification-content">{{ "  今天 12:40 西院会议室101" }}</p>
  </vant-step>
</template>

<script>
import { computed, ref } from "vue";

import { Step as VantStep } from "vant";

export default {
  name: "NotificationItem",
  components: { VantStep },
  props: {
    notificationType: {
      type: String,
      require: true,
    },
  },

  setup(props) {
    const notificationType = computed(() => props.notificationType);
    const styles = {
      "notification-circle-cancel": notificationType.value === "cancel",
      "notification-circle-change": notificationType.value === "change",
      "notification-circle-reassign": notificationType.value === "reassign",
      "notification-circle-remind": notificationType.value === "remind",
    };
    const styleObject = ref(styles);

    return {
      styleObject,
    };
  },
};
</script>

<style scoped>
.notification-content {
  margin: 2px 0;
  font: var(--font-heading-2);
}
</style>

<style lang="less">
.van-step__circle {
  width: 5px;
  height: 5px;
}
.notification-circle-cancel {
  color: var(--colors-red);
  & i {
    background-color: var(--colors-red);
  }
}
.notification-circle-change {
  color: var(--colors-blue);
  & i {
    background-color: var(--colors-blue);
  }
}
.notification-circle-reassign {
  color: var(--colors-orange);
  & i {
    background-color: var(--colors-orange);
  }
}
.notification-circle-remind {
  color: var(--colors-green);
  & i {
    background-color: var(--colors-green);
  }
}
</style>
