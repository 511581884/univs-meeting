<template>
  <div class="collegue-list">
    <div v-for="(collegue, index) in collegues" :key="collegue.id">
      <div class="collegue-item">
        <div class="container-left">
          <h4 class="collegue-name">{{ collegue.name }}</h4>
          <h5 class="collegue-department">{{ collegue.department.name }}</h5>
        </div>
        <div class="container-right">
          <vant-icon name="comment-circle-o" />
        </div>
      </div>
      <separator v-if="index !== collegues.length - 1"></separator>
    </div>
  </div>
</template>

<script>
import { ref } from "vue";

import { Icon as VantIcon } from "vant";
import Separator from "../common/Separator";
const c = [
  {
    id: 1,
    name: "李四",
    department: {
      id: 1,
      name: "教务办",
    },
  },
  {
    id: 2,
    name: "王五",
    department: {
      id: 1,
      name: "教务办",
    },
  },
  {
    id: 3,
    name: "张人杰",
    department: {
      id: 1,
      name: "教务办",
    },
  },
];

export default {
  components: { Separator, VantIcon },
  name: "CollegueList",
  setup() {
    const collegues = ref(c);

    return { collegues };
  },
};
</script>

<style scoped>
.collegue-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 5px;
}

.container-right {
  margin-right: 20px;
  display: flex;
  align-items: center;
}

.collegue-name {
  font: var(--font-heading-3);
  margin: 0 15px;
}

.collegue-department {
  font: var(--font-text-1);
  margin: 0 15px;
}
</style>
