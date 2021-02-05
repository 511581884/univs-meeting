<template>
  <View navBar navBarTitle="参会人员">
    <van-cell-group>
      <van-cell v-for="(item, index) in attendees" :key="index">
        <template #title>
          <span class="custom-title">{{ item.name }}</span>
        </template>
        <template #label>
          <span class="custom-title">{{
            item.isGuest ? "校外嘉宾" : item.department.name
          }}</span>
        </template>
        <template #right-icon>
          <van-icon name="phone-circle" @click="call(item.phone)" />
        </template>
      </van-cell>
    </van-cell-group>
  </View>
</template>

<script>
import {
  Icon as VanIcon,
  Cell as VanCell,
  CellGroup as VanCellGroup,
} from "vant";
import View from "@/components/common/View.vue";
import { useStore } from "vuex";
import { computed } from "vue";
export default {
  name: "AttendeesView",
  props: ["meetingId"],
  components: {
    VanIcon,
    VanCell,
    VanCellGroup,
    View,
  },
  setup(props) {
    const store = useStore();
    const attendees = computed(() => {
      return store.state.meeting.meetings[0].attendees;
    });

    const call = (phone) => {
      window.location.href = `tel:${phone}`;
    };

    console.log("meetingId:", props.meetingId);
    return {
      attendees,
      call,
    };
  },
};
</script>

<style lang="less" scoped>
.van-cell-group {
  font: var(--font-text-1);
  .van-cell {
    .van-icon {
      font-size: 40px;
      right: 5px;
    }
  }
}
</style>
