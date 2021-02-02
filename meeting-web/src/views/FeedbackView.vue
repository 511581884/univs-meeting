<template>
  <View navBar navBarTitle="会议反馈">
    <div class="container">
      <span>请输入反馈内容：</span>
      <van-field
        v-model="fbMsg"
        rows="10"
        autosize
        type="textarea"
        placeholder="反馈内容..."
      />
      <div class="btn">
        <van-button plain type="success" block>提交反馈</van-button>
      </div>
    </div>
  </View>
</template>

<script>
import { ref } from "vue";

import { Field as VanField, Button as VanButton } from "vant";
import View from "@/components/common/View.vue";

export default {
  name: "FeedbackView",
  components: { VanField, VanButton, View },
  setup() {
    const fbMsg = ref("");
    return {
      fbMsg,
    };
  },
};
</script>

<style lang="less" scoped>
.container {
  font: var(--font-heading-2);
  position: relative;
  top: 30px;
  span {
    position: relative;
    left: 15px;
  }
  .btn {
    width: 200px;
    margin: 10px auto;
    .van-button {
      font-weight: 600;
      height: 35px;
    }
  }
}
</style>
