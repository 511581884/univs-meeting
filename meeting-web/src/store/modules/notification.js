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
  },
  actions: {
    fetchNotifications: async ({ commit }) => {
      const notifications = await getNotifications();
      commit("updateNotifications", notifications);
    },
  },
  getters: {
    getTopThreeNotifications: (state) => {
      return state.notifications.slice(0, 3);
    },
    getUnreadAmount: (state) => {
      return state.notifications.filter((n) => !n.hasRead).length;
    },
  },
};

export default notificationModule;
