<template>
  <View tabBar>
    <div class="container">
      <profile></profile>
    </div>
  </View>
</template>

<script>
import View from "../components/common/View";
import Profile from "../components/my-meeting/Profile";

export default {
  components: { View, Profile },
  name: "MyMeetingsView",
  setup() {
    return {};
  },
};
</script>

<style scoped></style>
