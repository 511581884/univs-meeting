<template>
  <vant-steps direction="vertical" class="previews-list" :active="-1">
    <preview-item previewType="cancel"></preview-item>
    <preview-item previewType="remind"></preview-item>
    <preview-item previewType="change"></preview-item>
  </vant-steps>
</template>

<script>
import { Steps as VantSteps } from "vant";
import PreviewItem from "./PreviewItem";

export default {
  name: "PreviewList",
  components: { PreviewItem, VantSteps },
  setup() {
    return {};
  },
};
</script>

<style scoped>
.previews-list {
  padding-left: 50px;
}
</style>
