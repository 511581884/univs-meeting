<template>
  <div class="body">
    <van-cell-group>
      <van-cell title="参会人员" is-link />
      <van-cell
        title="会议文件"
        is-link
        @click="clickFilesCell"
        :arrow-direction="filesCellArrowDirection"
      />
      <transition name="files-open">
        <div v-if="isBrowseFiles" class="files">
          <van-cell
            v-for="(item, index) in details.files"
            :key="index"
            :title="item.name"
            is-link
            icon="orders-o"
          />
        </div>
      </transition>
      <van-cell title="会后反馈" is-link />
    </van-cell-group>
    <div class="btns">
      <van-button class="join">参会</van-button>
      <van-button class="leave" @click="askForLeave">请假</van-button>
      <van-button class="reassign">代会</van-button>
    </div>
  </div>

  <!--'请假'弹窗-->
  <van-dialog
    confirmButtonColor="var(--colors-details-btn-blue)"
    v-model:show="isAskForLeave"
    title="请输入请假原因"
    show-cancel-button
  >
    <van-field
      v-model="leaveReason"
      rows="3"
      autosize
      type="textarea"
      placeholder="在此输入请假原因..."
    />
  </van-dialog>
</template>

<script>
import { ref } from 'vue'
import {
  Cell as VanCell,
  CellGroup as VanCellGroup,
  Button as VanButton,
  Dialog,
  Field as VanField,
} from "vant";
export default {
  name: "HandlerArea",
  props: {
    details: {
      type: Object,
      required: true
    }
  },
  components: {
    VanCell,
    VanCellGroup,
    VanButton,
    [Dialog.Component.name]: Dialog.Component,
    VanField,
  },
  setup() {
    /* “会议文件”的展开和关闭  */
    const isBrowseFiles = ref(false);
    const filesCellArrowDirection = ref("");
    const clickFilesCell = () => {
      isBrowseFiles.value = !isBrowseFiles.value;
      filesCellArrowDirection.value = isBrowseFiles.value ? "down" : "";
    };
    /* 点击“请假” */
    const isAskForLeave = ref(false);
    const askForLeave = () => {
      isAskForLeave.value = true;
    };
    const leaveReason = ref("");
    return {
      isBrowseFiles,
      filesCellArrowDirection,
      clickFilesCell,
      askForLeave,
      isAskForLeave,
      leaveReason,
    }
  }

};
</script>


<style lang="less" scoped>
.body {
  font: var(--font-text-1);
  .btns {
    margin-top: 30px;
    button {
      height: 100px;
      width: 100px;
      border-radius: 50%;
      margin: 0 12px;
      font-size: 18px;
      color: var(--colors-white);
    }
    .join {
      background-color: var(--colors-details-btn-green);
      border: 1px solid var(--colors-details-btn-green);
    }
    .leave {
      background-color: var(--colors-details-btn-red);
      border: 1px solid var(--colors-details-btn-red);
    }
    .reassign {
      background-color: var(--colors-details-btn-orange);
      border: 1px solid var(--colors-details-btn-orange);
    }
  }
}
/* “会议文件”展开和关闭的动画效果 */
.files-open-enter-active {
  animation: files 0.3s;
}
.files-open-leave-active {
  animation: files 0.3s reverse;
}
@keyframes files {
  from {
    transform: scaleY(0.1);
  }
  to {
    transform: scaleY(1);
  }
}
</style>