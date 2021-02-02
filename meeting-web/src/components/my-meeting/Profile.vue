<template>
  <div class="profile">
    <img
      class="avatar"
      src="https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2263294381,1297061577&fm=26&gp=0.jpg"
    />
    <div class="container-middle">
      <h4 class="profile-name">
        <span class="text-previous">李四</span
        ><span class="text-following">老师</span>
      </h4>
      <p class="profile-department">
        <span class="text-previous">所属部门:</span
        ><span class="text-following">教务处</span>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "Profile",
  setup() {
    return {};
  },
};
</script>

<style scoped>
.avatar {
  width: 70px;
  height: 70px;
  border-radius: 50%;
  margin-left: 30px;
}

.container-middle {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  margin-left: 20px;
  flex: 1;
}

.profile {
  width: 100%;
  height: 10vh;
  padding: 20px 0;
  display: flex;
  align-items: center;
  box-shadow: var(--shadow-separator);
}
.profile-name {
  font: var(--font-heading-2);
  margin: 5px 0;
}
.profile-department {
  margin: 5px 0;
  font: var(--font-text-1);
  color: var(--colors-medium);
}

.text-previous {
  display: inline-block;
  width: 60px;
}

.text-following {
}
</style>
