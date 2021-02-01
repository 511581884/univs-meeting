<template>
  <popup v-model:show="visible" position="bottom" round class="popup">
    <vant-datetime-picker
      v-model="currentDate"
      type="date"
      title="选择日期"
      @confirm="onConfirm"
      :min-date="minDate"
      :max-date="maxDate"
    ></vant-datetime-picker>
  </popup>
</template>

<script>
import { DatetimePicker as VantDatetimePicker, Popup } from "vant";
import { computed, ref } from "vue";

export default {
  components: { VantDatetimePicker, Popup },
  name: "DatePicker",
  props: ["show"],
  setup(props, context) {
    const today = new Date();
    const minDate = ref(new Date(today.getFullYear() - 2, 0, 1));
    const maxDate = ref(new Date(today.getFullYear() + 2, 0, 1));

    const visible = computed(() => props.show);

    const onConfirm = (date) => context.emit("confirm", date);

    return {
      currentDate: today,
      minDate,
      maxDate,
      onConfirm,
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
