<template>
  <View tabBar>
    <div class="container">
      <profile />
      <notification-previews />
      <linked-cell routeName="History" label="历史会议" />
    </div>
  </View>
</template>

<script>
import View from "../components/common/View";
import LinkedCell from "../components/common/LinkedCell";
import Profile from "../components/my-meeting/Profile";
import NotificationPreviews from "../components/my-meeting/notification/NotificationPreviews";

export default {
  components: { NotificationPreviews, Profile, LinkedCell, View },
  name: "MyMeetingsView",
};
</script>

<style scoped></style>
