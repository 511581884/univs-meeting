<template>
  <View navBar navBarTitle="代会">
    <div>
      <colleague-list></colleague-list>
    </div>
  </View>
</template>

<script>
import View from "../components/common/View";
import ColleagueList from "../components/reassignment/ColleagueList";

export default {
  name: "ReassignmentView",
  props:["meetingId"],
  components: { ColleagueList, View },
  setup(props) {
    console.log(props.meetingId)
  }
};
</script>
