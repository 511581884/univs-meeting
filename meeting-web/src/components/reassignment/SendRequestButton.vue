<template>
  <vant-icon @click="handleButtonClick" name="comment-circle-o" />
</template>

<script>
// import { computed } from "vue";

import { Icon as VantIcon } from "vant";
// import { sendReassignmentRequest } from "@/api/fakeMemberService";

export default {
  name: "SendRequestButton",
  components: { VantIcon },
  props: ["colleagueId"],

  setup() {
    // const colleagueId = computed(() => props.colleagueId);

    const handleButtonClick = async () => {
      // const response = await sendReassignmentRequest(colleagueId, "myId");
      // console.log("response: ", response);
    };

    return { handleButtonClick };
  },
};
</script>

<style scoped></style>
