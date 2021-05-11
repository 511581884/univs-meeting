<template>
  <div class="separator" :style="{ width: `${widthPercent}%` }" />
</template>

<script>
export default {
  name: "Separator",
  props: {
    widthPercent: {
      type: Number,
      default: 90,
    },
  },
};
</script>

<style scoped>
.separator {
  background-color: var(--colors-medium);
  border-radius: 5px;
  cursor: auto;
  height: 1.5px;
  margin: 5px auto;
  opacity: 0.4;
  /* width: 90%; */
}
</style>
