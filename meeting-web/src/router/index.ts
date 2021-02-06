import {
  createRouter,
  createWebHistory,
  RouteRecordRaw,
  RouterOptions,
} from "vue-router";

const routes: RouteRecordRaw[] = [
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
    path: "/details/:meetingId",
    name: "Details",
    component: () => import("../views/DetailsView.vue"),
    props: true,
  },
  {
    path: "/attendees/:meetingId",
    name: "Attendees",
    component: () => import("../views/AttendeesView.vue"),
    props: true,
  },
  {
    path: "/feedback/:meetingId",
    name: "Feedback",
    component: () => import("../views/FeedbackView.vue"),
    props: true,
  },
  {
    path: "/reassignment/:meetingId",
    name: "Reassignment",
    component: () => import("../views/ReassignmentView.vue"),
    props: true,
  },
  {
    path: "/me",
    name: "MyMeetings",
    component: () => import("../views/MyMeetingsView.vue"),
  },
  {
    path: "/notifications",
    name: "NotificationCenter",
    component: () => import("../views/NotificationCenterView.vue"),
  },
  {
    path: "/history",
    name: "HistoryMeeting",
    component: () => import("../views/HistoryMeetingView.vue"),
  },
  {
    path: "/",
    redirect: "/week",
  },
];

const routerOptions: RouterOptions = {
  history: createWebHistory(),
  routes,
};

const router = createRouter(routerOptions);

export default router;
