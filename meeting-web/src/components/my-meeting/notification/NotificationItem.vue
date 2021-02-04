<template>
  <vant-step class="notification-item" :class="className">
    <div class="notification-content">
      <basic-content :type="type" :meetingName="meetingName" />
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
      <regular-content v-else :notification="notification" />
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
    const className = ref(`notification-content-${type.value}`);

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

<style lang="less">
.notification-content > p {
  margin: 2px 0;
  font: var(--font-heading-2);
}
.notification-content-cancel {
  color: var(--colors-red);
  & i {
    background-color: var(--colors-red);
  }
}
.notification-content-change {
  color: var(--colors-blue);
  & i {
    background-color: var(--colors-blue);
  }
}
.notification-content-reassign {
  color: var(--colors-orange);
  & i {
    background-color: var(--colors-orange);
  }
}
.notification-content-remind {
  color: var(--colors-green);
  & i {
    background-color: var(--colors-green);
  }
}
.van-step__circle {
  width: 5px;
  height: 5px;
}
</style>
