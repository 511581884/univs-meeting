import { createRouter, createWebHistory } from "vue-router";

const routes = [
  {
    path: "/WeekView",
    name: "WeekView",
    component: () => import("../views/WeekView.vue"),
  },
  {
    path: "/month",
    name: "Month",
    component: () => import("../views/MonthView.vue"),
  },
  // {
  //   path: "/",
  //   name: "Home",
  //   component: Home,
  // },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
