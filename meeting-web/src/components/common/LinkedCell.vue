<template>
  <vant-cell :value="label" is-link @click="goTo(routeName)" />
</template>

<script>
import { useRouter } from "vue-router";

import { Cell as VantCell } from "vant";

export default {
  name: "LinkedCell",
  components: { VantCell },
  props: ["routeName", "label"],
  setup() {
    const router = useRouter();
    const goTo = (name) => {
      router.push({
        name,
      });
    };
    return {
      goTo,
    };
  },
};
</script>

<style>
.van-cell__value {
  font: var(--font-heading-2);
}
</style>
