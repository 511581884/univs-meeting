// NabBar: 顶部返回栏
<template>
  <vant-nav-bar :title="title" left-arrow></vant-nav-bar>
</template>

<script>
import { NavBar as VantNavBar } from "vant";

export default {
  name: "NavBar",
  components: { VantNavBar },
  props: ["title"],
};
</script>

<style scoped></style>
