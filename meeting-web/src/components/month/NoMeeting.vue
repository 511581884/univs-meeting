<template>
  <vant-empty class="empty" description="今天没有会议安排" />
</template>

<script>
import { Empty as VantEmpty } from "vant";

export default {
  name: "NoMeeting",
  components: { VantEmpty },
};
</script>

<style>
.empty {
  height: 50%;
}
.van-empty__image {
  width: 160px;
  height: 160px;
  margin-top: 50px;
}

.van-empty__description {
  margin: 0;
  padding: 0;
  color: var(--colors-medium);
  font: var(--font-heading-3);
}
</style>
