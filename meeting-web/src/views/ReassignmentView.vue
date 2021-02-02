<template>
  <View navBar navBarTitle="代会">
    <div>
      <collegue-list></collegue-list>
    </div>
  </View>
</template>

<script>
import View from "../components/common/View";
import CollegueList from "../components/reassignment/CollegueList";

export default {
  name: "ReassignmentView",
  components: { CollegueList, View },
};
</script>
