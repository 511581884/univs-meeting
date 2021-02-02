import { createRouter, createWebHistory } from "vue-router";

const routes = [
  {
    path: "/week",
    name: "Week",
    component: () => import("../views/WeekView.vue"),
  },
  {
    path: "/month",
    name: "Month",
    component: () => import("../views/MonthView.vue"),
  },
  {
    path: "/details",
    name: "Details",
    component: () => import("../views/DetailsView.vue"),
  },
  {
    path: "/attendees",
    name: "Attendees",
    component: () => import("../views/AttendeesView.vue"),
  },
  {
    path: "/feedback",
    name: "Feedback",
    component: () => import("../views/FeedbackView.vue"),
  },
  {
    path: "/reassignment",
    name: "Reassignment",
    component: () => import("../views/ReassignmentView.vue"),
  },
  {
    path: "/me",
    name: "MyMeetings",
    component: () => import("../views/MyMeetingsView.vue"),
  },
  {
    path: "/",
    redirect: "/week",
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
