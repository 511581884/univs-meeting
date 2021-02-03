<template>
  <vant-step class="preview-item" :class="styleObject">
    <p class="preview-content">【到会提醒】学校优秀辅导员座谈会</p>
    <p class="preview-content">{{ "  今天 12:40 西院会议室101" }}</p>
  </vant-step>
</template>

<script>
import { computed, ref } from "vue";

import { Step as VantStep } from "vant";

export default {
  name: "PreviewItem",
  components: { VantStep },
  props: {
    previewType: {
      type: String,
      require: true,
    },
  },

  setup(props) {
    const previewType = computed(() => props.previewType);
    const styles = {
      "preview-circle-cancel": previewType.value === "cancel",
      "preview-circle-change": previewType.value === "change",
      "preview-circle-reassign": previewType.value === "reassign",
      "preview-circle-remind": previewType.value === "remind",
    };
    const styleObject = ref(styles);

    return {
      styleObject,
    };
  },
};
</script>

<style scoped>
.preview-content {
  margin: 2px 0;
  font: var(--font-heading-2);
}
</style>

<style lang="less">
.van-step__circle {
  width: 5px;
  height: 5px;
}
.preview-circle-cancel {
  color: var(--colors-red);
  & i {
    background-color: var(--colors-red);
  }
}
.preview-circle-change {
  color: var(--colors-blue);
  & i {
    background-color: var(--colors-blue);
  }
}
.preview-circle-reassign {
  color: var(--colors-orange);
  & i {
    background-color: var(--colors-orange);
  }
}
.preview-circle-remind {
  color: var(--colors-green);
  & i {
    background-color: var(--colors-green);
  }
}
</style>
