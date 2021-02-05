import _ from "lodash";

import { getNotifications } from "../../api/fakeNotificationService";
import {
  NotificationState,
  NotificationMutations,
  NotificationActions,
  NotificationGetters,
  NotificationStore,
} from "../types";

const state: NotificationState = {
  notifications: [],
  length: 0,
};

const mutations: NotificationMutations = {
  updateNotifications(state, notifications) {
    state.notifications = notifications;
    state.length = notifications.length;
  },
  makeAllRead(state) {
    state.notifications.forEach((n) => {
      n.hasRead = true;
    });
  },
};

const actions: NotificationActions = {
  fetchNotifications: async ({ commit }) => {
    const notifications = await getNotifications();
    const sorted = _.orderBy(
      notifications,
      (notification) => notification.createDate,
      "desc"
    );
    commit("updateNotifications", sorted);
  },

  makeAllRead: ({ commit }) => {
    commit("makeAllRead");
  },
};

const getters: NotificationGetters = {
  getTopThreeNotifications: (state) => {
    return state.notifications.slice(0, 3);
  },
  getUnreadAmount: (state) => {
    return state.notifications.filter((n) => !n.hasRead).length;
  },
  getCategorizedByDate: (state) => {
    return _.groupBy(state.notifications, (n) => {
      if (typeof n.hasConfirm === "boolean" && !n.hasConfirm)
        return "unconfirmed";
      return n.createDate.toDateString();
    });
  },
};

const notificationStore: NotificationStore = {
  namespaced: true,
  state,
  actions,
  mutations,
  getters,
};

export default notificationStore;
