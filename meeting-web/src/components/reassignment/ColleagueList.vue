<template>
  <div class="colleague-list">
    <div v-for="(colleague, index) in colleagues" :key="colleague.id">
      <colleague-item :colleague="colleague" />
      <separator v-if="index !== colleagues.length - 1" />
    </div>
  </div>
</template>

<script>
import { onBeforeMount, ref } from "vue";

import { getColleague } from "../../api/fakeMemberService";
import Separator from "../common/Separator";
import ColleagueItem from "./ColleagueItem";

export default {
  components: { Separator, ColleagueItem },
  name: "ColleagueList",
  setup() {
    const colleagues = ref([]);

    onBeforeMount(async () => {
      colleagues.value = await getColleague("userId");
    });

    return { colleagues };
  },
};
</script>

<style scoped></style>
