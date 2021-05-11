// NabBar: 顶部返回栏
<template>
  <vant-nav-bar :title="title" left-arrow @click-left="onClickLeft" />
</template>

<script>
import { NavBar as VantNavBar } from "vant";
import { useRouter } from "vue-router";
export default {
  name: "NavBar",
  components: { VantNavBar },
  props: ["title"],
  setup() {
    const router = useRouter();
    const onClickLeft = () => {
      router.back();
    };
    return {
      onClickLeft,
    };
  },
};
</script>

<style scoped></style>
