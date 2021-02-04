<template>
  <div class="badge" v-if="content">{{ content }}</div>
</template>

<script>
export default {
  name: "Badge",
  props: ["content"],
};
</script>

<style scoped>
.badge {
  position: absolute;
  top: -3%;
  right: 11%;
  padding: 1px 5px;
  border-radius: 10px;
  background: var(--colors-red);
  color: var(--colors-white);
}
</style>
