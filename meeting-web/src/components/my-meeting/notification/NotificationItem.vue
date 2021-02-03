<template>
  <vant-step class="notification-item" :class="styleObject">
    <p class="notification-content">
      {{ `【${label} ${notification.meetingName}】` }}
    </p>
    <p class="notification-content" v-if="!isReassignment">
      {{ "  今天 12:40 西院会议室101" }}
    </p>
  </vant-step>
</template>

<script>
import { computed, ref } from "vue";
// import dayjs from "dayjs";

import { Step as VantStep } from "vant";

const OPTIONS = {
  cancel: {
    class: "notification-circle-cancel",
    label: "会议取消",
  },
  change: {
    class: "notification-circle-change",
    label: "会议变更",
  },
  reassign: {
    class: "notification-circle-reassign",
    label: "改派请求",
  },
  remind: {
    class: "notification-circle-remind",
    label: "会议提醒",
  },
};

export default {
  name: "NotificationItem",
  components: { VantStep },
  props: ["notification"],

  setup(props) {
    const type = computed(() => props.notification.type);

    const isReassignment = computed(() => type.value === "reassign");
    const className = ref(OPTIONS[type.value].class);
    const label = ref(OPTIONS[type.value].label);

    // const startDateString = computed(() => {
    //   if (isReassignment.value) return null;
    // });

    return {
      className,
      isReassignment,
      label,
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
