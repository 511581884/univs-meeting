<template>
  <View tabBar>
    <div class="container">
      <profile />
      <notification-previews />
      <vant-cell-group>
        <vant-cell value="历史会议" is-link @click="goTo('MeetingHistories')" />
      </vant-cell-group>
    </div>
  </View>
</template>

<script>
import { useRouter } from "vue-router";

import { Cell as VantCell, CellGroup as VantCellGroup } from "vant";
import View from "../components/common/View";
import Profile from "../components/my-meeting/Profile";
import NotificationPreviews from "../components/my-meeting/notification/NotificationPreviews";

export default {
  components: { NotificationPreviews, Profile, VantCell, VantCellGroup, View },
  name: "MyMeetingsView",
  setup() {
    const router = useRouter();
    const goTo = (name) => {
      router.push({
        name,
      });
    };
    return {
      goTo,
    };
  },
};
</script>

<style scoped></style>
