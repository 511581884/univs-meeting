<template>
  <div class="colleague-item">
    <div class="container-left">
      <h4 class="colleague-name">{{ colleague.name }}</h4>
      <h5 class="colleague-department">{{ colleague.department.name }}</h5>
    </div>
    <div class="container-right">
      <send-request-button :colleagueId="colleague.id" />
    </div>
  </div>
</template>

<script>
import SendRequestButton from "./SendRequestButton";

export default {
  components: { SendRequestButton },
  name: "ColleagueItem",
  props: ["colleague"],
};
</script>

<style scoped>
.colleague-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 5px;
}

.container-right {
  margin-right: 20px;
  display: flex;
  align-items: center;
}

.colleague-name {
  font: var(--font-heading-3);
  margin: 0 15px;
}

.colleague-department {
  font: var(--font-text-1);
  margin: 0 15px;
}
</style>
