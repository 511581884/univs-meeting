<template>
  <div class="container">
    <div class="heading-container">
      <h3 class="heading">通知中心</h3>
    </div>
    <preview-list></preview-list>
  </div>
</template>

<script>
import PreviewList from "./PreviewList";
export default {
  components: { PreviewList },
  name: "NotificationPreviews",
  setup() {
    return {};
  },
};
</script>

<style scoped>
.container {
  height: max-content;
  box-shadow: 0px 2px 1px -1px rgba(0, 0, 0, 0.2),
    0px 1px 1px 0px rgba(0, 0, 0, 0.14), 0px 1px 3px 0px rgba(0, 0, 0, 0.12);
}

.heading-container {
  width: 100%;
  height: 5vh;
  padding: 10px 0;
  /* background-color: red; */
  display: flex;
  align-items: center;
}

.heading {
  margin: 0;
  margin-left: 30px;
  font: var(--font-heading-1);
}
</style>
