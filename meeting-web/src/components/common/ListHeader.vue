<template>
  <h3 class="list-header">
    <slot />
  </h3>
</template>

<script>
export default {
  name: "ListHeader",
};
</script>

<style scoped>
.list-header {
  background-color: var(--colors-light);
  margin: 2px 0;
  font: var(--font-heading-2);
  padding: 2px;
  padding-left: 20px;
}
</style>
