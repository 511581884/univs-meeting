import { getNotifications } from "../../api/fakeNotificationService";

const notificationModule = {
  state: () => ({
    notifications: [],
  }),
  mutations: {
    updateNotifications(state, notifications) {
      state.notifications = notifications;
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
  },
};

export default notificationModule;
