<template>
  <View navBar navBarTitle="会议详情">
    <meeting-info :details="details" />
    <handler-area :details="details" />
  </View>
</template>

<script>
import { useStore } from "vuex";
import { computed } from "vue";

import HandlerArea from "@/components/details/HandlerArea.vue";
import MeetingInfo from "@/components/details/MeetingInfo.vue";
import View from "@/components/common/View.vue";
export default {
  name: "DetailsView",
  components: {
    MeetingInfo,
    HandlerArea,
    View,
  },
  setup() {
    const store = useStore();
    const details = computed(() => store.state.meetings[0]);
    return {
      details,
    };
  },
};
</script>
