<template>
  <div class="colleague-list">
    <div v-for="(colleague, index) in colleagues" :key="colleague.id">
      <colleague-item :colleague="colleague"></colleague-item>
      <separator v-if="index !== colleagues.length - 1"></separator>
    </div>
  </div>
</template>

<script>
import { ref } from "vue";

import Separator from "../common/Separator";
import ColleagueItem from "./ColleagueItem";

export default {
  components: { Separator, ColleagueItem },
  name: "ColleagueList",
  setup() {
    const colleagues = ref([]);

    return { colleagues };
  },
};
</script>

<style scoped></style>
