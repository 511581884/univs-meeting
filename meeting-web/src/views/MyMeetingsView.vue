<template>
  <View tabBar>
    <div class="container">
      <profile></profile>
      <notification-previews></notification-previews>
    </div>
  </View>
</template>

<script>
import View from "../components/common/View";
import Profile from "../components/my-meeting/Profile";
import NotificationPreviews from "../components/my-meeting/NotificationPreviews";

export default {
  components: { View, Profile, NotificationPreviews },
  name: "MyMeetingsView",
  setup() {
    return {};
  },
};
</script>

<style scoped></style>
