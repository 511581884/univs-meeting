import { createRouter, createWebHistory } from "vue-router";

const routes = [
   {
     path: "/WeekView",
     name: "WeekView",
     component: () => import('../views/WeekView.vue'),
   },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
