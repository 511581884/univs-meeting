<template>
  <vant-popup v-model="visible">
    <vant-datetime-picker
      v-model="selected"
      type="date"
      title="选择日期"
      :min-date="minDate"
      :max-date="maxDate"
    ></vant-datetime-picker>
  </vant-popup>
</template>

<script>
import { DatetimePicker as VantDatetimePicker, Popup as VantPopup } from "vant";
import { computed, ref } from "vue";

export default {
  name: "DatePicker",
  components: { VantDatetimePicker, VantPopup },
  props: ["selectedDate", "show"],
  setup(props) {
    const today = new Date();
    const minDate = ref(new Date(today.getFullYear() - 2, 0, 1));
    const maxDate = ref(new Date(today.getFullYear() + 2, 0, 1));
    const selectedDate = computed(() => props.selectedDate);
    const visible = computed(() => props.show);

    console.log("selectedDate: ", selectedDate);

    return {
      minDate,
      maxDate,
      selected: selectedDate,
      visible,
    };
  },
};
</script>

<style scoped>
.popup {
  height: 50%;
  width: 100%;
}
</style>
