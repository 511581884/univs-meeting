import { createStore } from "vuex";
import _ from "lodash";

import notificationModule from "./modules/notification";
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
  getters: {
    getMeetings(state) {
      return _.sortBy(state.meetings, (meeting) => meeting.startDate);
    },
    datesHaveMeeting(state) {
      const dates = state.meetings.map(({ startDate }) => ({
        year: startDate.getFullYear(),
        month: startDate.getMonth(),
        date: startDate.getDate(),
      }));

      const unique = _.uniqWith(dates, _.isEqual);
      return unique.map((date) => new Date(date.year, date.month, date.date));
    },
  },
  modules: {
    notification: notificationModule,
  },
};

const store = createStore(storeConfig);

export default store;
