<template>
  <View navBar navBarTitle="会议详情">
    <meeting-info :details="details" />
    <handler-area :details="details" />
  </View>
</template>

<script>
import { computed } from "vue";

import HandlerArea from "@/components/details/HandlerArea.vue";
import MeetingInfo from "@/components/details/MeetingInfo.vue";
import View from "@/components/common/View.vue";
import { useStore } from "@/hooks/store";
export default {
  name: "DetailsView",
  props: ["meetingId"],
  components: {
    MeetingInfo,
    HandlerArea,
    View,
  },
  setup(props) {
    const store = useStore();
    const details = computed(() => store.state.meeting.meetings[0]);

    console.log(props.meetingId);
    return {
      details,
    };
  },
};
</script>

<style scoped></style>
