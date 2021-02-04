<template>
  <vant-step class="notification-item" :class="className">
    <div class="notification-content">
      <basic-content :type="type" :meetingName="meetingName"></basic-content>
    </div>
    <div class="notification-content">
      <change-content
        v-if="isChange"
        :notification="notification"
      ></change-content>
      <reassignment-content
        v-else-if="isReassignment"
        :notification="notification"
      ></reassignment-content>
      <regular-content v-else :notification="notification"></regular-content>
    </div>
  </vant-step>
</template>

<script>
import { computed, ref } from "vue";

import { Step as VantStep } from "vant";
import BasicContent from "./content/BasicContent";
import ChangeContent from "./content/ChangeContent";
import RegularContent from "./content/RegularContent";
import ReassignmentContent from "./content/ReassignmentContent";

export default {
  name: "NotificationItem",
  components: {
    VantStep,
    BasicContent,
    ChangeContent,
    RegularContent,
    ReassignmentContent,
  },
  props: ["notification"],

  setup(props) {
    const type = computed(() => props.notification.type);
    const meetingName = computed(() => props.notification.meetingName);
    const className = ref(`notification-circle-${type.value}`);

    const isReassignment = ref(type.value === "reassign");
    const isChange = ref(type.value === "change");

    return {
      className,
      isReassignment,
      isChange,
      type,
      meetingName,
    };
  },
};
</script>

<style scoped>
.notification-content > p {
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
