import _ from "lodash";

import { getNotifications } from "../../api/fakeNotificationService";

const notificationModule = {
  state: () => ({
    notifications: [],
  }),
  mutations: {
    updateNotifications(state, notifications) {
      state.notifications = notifications;
      state.length = notifications.length;
    },
    makeAllRead(state) {
      state.notifications.forEach((n) => {
        n.hasRead = true;
      });
    },
  },
  actions: {
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
  },
  getters: {
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
  },
};

export default notificationModule;
