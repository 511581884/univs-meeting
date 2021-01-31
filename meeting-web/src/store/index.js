import { createStore } from "vuex";

import { getMeetings } from "../api/fakeMeetingService";

const storeConfig = {
  state() {
    return {
      meetings: [],
    };
  },
  mutations: {
    updateMeetings(state, meetings) {
      state.meetings = meetings;
    },
  },
  actions: {
    fetchMeetings: async ({ commit }) => {
      const meetings = await getMeetings();
      commit("updateMeetings", meetings);
    },
  },
  modules: {},
};

const store = createStore(storeConfig);

export default store;
