<template>
  <nav-bar v-if="navBar" :title="navBarTitle" />
  <slot />
  <tab-bar v-if="tabBar" />
</template>

<script>
import NavBar from "../layout/NavBar.vue";
import TabBar from "../layout/TabBar.vue";

export default {
  components: { TabBar, NavBar },
  name: "View",
  props: {
    tabBar: {
      type: Boolean,
      default: false,
    },
    navBar: {
      type: Boolean,
      default: false,
    },
    navBarTitle: {
      type: String,
      default: "",
    },
  },
};
</script>
