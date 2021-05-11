<template>
  <div class="body">
    <van-cell-group>
      <van-cell title="参会人员" is-link @click="goTo('Attendees')"/>
      <van-collapse v-model="openUnit">
        <van-collapse-item title="会议文件" name="files">
          <div v-if='details.files'>
          <van-cell
            v-for="(item, index) in details.files"
            :key="index"
            :title="item.name"
            is-link
            icon="orders-o"
            @click="goTo('File')"
          />
          </div>
          <div v-else class='no-files'>
            <span>暂无相关会议文件</span>
          </div>
        </van-collapse-item>
      </van-collapse>
      <van-cell title="会后反馈" is-link @click="goTo('Feedback')"/>
    </van-cell-group>
    <div class="btns">
      <van-button class="join">参会</van-button>
      <van-button class="leave" @click="askForLeave">请假</van-button>
      <van-button class="reassign" @click="goTo('Reassignment')">代会</van-button>
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
import { ref } from "vue";
import { useRouter } from 'vue-router'
import {
  Cell as VanCell,
  CellGroup as VanCellGroup,
  Button as VanButton,
  Dialog,
  Field as VanField,
  Collapse as VanCollapse,
  CollapseItem as VanCollapseItem,
} from "vant";
export default {
  name: "HandlerArea",
  props: {
    details: {
      type: Object,
      required: true,
    },
  },
  components: {
    VanCell,
    VanCellGroup,
    VanButton,
    [Dialog.Component.name]: Dialog.Component,
    VanField,
    VanCollapse,
    VanCollapseItem,
  },
  setup(props) {
    /* “会议文件”的展开和关闭  */
    const openUnit = ref(["file"]);
    /* 点击“请假” */
    const isAskForLeave = ref(false);
    const askForLeave = () => {
      isAskForLeave.value = true;
    };
    const leaveReason = ref("");
    /* 路由跳转 */
    const router = useRouter()
    // eslint-disable-next-line vue/no-setup-props-destructure
    const meetingId = props.details.id;
    const goTo = (name) => {
      router.push({
        name,
        params:{ meetingId }
      })
    }
    // eslint-disable-next-line vue/no-setup-props-destructure
    
    return {
      askForLeave,
      isAskForLeave,
      leaveReason,
      openUnit,
      goTo
    };
  },
};
</script>


<style lang="less" scoped>
.body {
  font: var(--font-text-1);
  .no-files{
    display: flex;
    justify-content: center;
  }
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
</style>