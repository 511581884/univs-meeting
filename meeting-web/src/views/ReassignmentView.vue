<template>
  <nav-bar title="代会"></nav-bar>
  <div>
    <collegue-list></collegue-list>
  </div>
</template>

<script>
import NavBar from "../components/layout/NavBar";
import CollegueList from "../components/reassignment/CollegueList";

export default {
  name: "ReassignmentView",
  components: { CollegueList, NavBar },
  setup() {},
};
</script>

<style scoped></style>
