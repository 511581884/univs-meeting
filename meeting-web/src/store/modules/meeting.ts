import _ from "lodash";

import {
  Meeting,
  MeetingState,
  MeetingMutations,
  MeetingActions,
  MeetingGetters,
  MeetingStore,
} from "@/types";
import { getMeetings } from "@/api/fakeMeetingService";

const state: MeetingState = {
  meetings: [],
};

const mutations: MeetingMutations = {
  updateMeetings(state, meetings: Meeting[]) {
    state.meetings = meetings;
  },
};

const actions: MeetingActions = {
  async fetchMeetings({ commit }) {
    const meetings = await getMeetings();
    commit("updateMeetings", meetings);
  },
};

const getters: MeetingGetters = {
  getMeetings: (state) => {
    return _.sortBy(state.meetings, (meeting) => meeting.startDate);
  },
  datesHaveMeeting(state) {
    const dates = state.meetings.map(({ startDate }) => ({
      year: startDate.getFullYear(),
      month: startDate.getMonth(),
      date: startDate.getDate(),
    }));

    const unique: typeof dates = _.uniqWith(dates, _.isEqual);
    return unique.map(({ year, month, date }) => new Date(year, month, date));
  },
};

const meetingModule: MeetingStore = {
  namespaced: true,
  state,
  mutations,
  actions,
  getters,
};

export default meetingModule;
