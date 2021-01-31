import { createRouter, createWebHistory } from "vue-router";

import MonthView from "../views/MonthView.vue";

const routes = [
  {
    path: "/WeekView",
    name: "WeekView",
    component: () => import("../views/WeekView.vue"),
  },
  {
    path: "/month",
    name: "Month",
    component: MonthView,
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
