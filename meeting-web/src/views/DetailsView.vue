<template>
  <meeting-info :details="details" />
  <handler-area :details="details" />
</template>

<script>
import { useStore } from "vuex";
import { computed } from "vue";
import HandlerArea from "@/components/Details/HandlerArea.vue";
import MeetingInfo from "@/components/Details/MeetingInfo.vue";
export default {
  name: "DetailsView",
  components: {
    MeetingInfo,
    HandlerArea,
  },
  setup() {
    const store = useStore();
    const details = computed(() => 
       store.state.meetings[0]
    );
    return {
      details,
    };
  },
};
</script>

