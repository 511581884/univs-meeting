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
import { areSameDate } from "@/helpers/dateTime";

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
    return _.orderBy(state.meetings, (meeting) => meeting.startDate, "desc");
  },
  getMeetingsByDate: (state, date: Date) => {
    const meetings = state.meetings.filter((meeting) =>
      areSameDate(meeting.startDate, date)
    );
    return _.orderBy(meetings, (meeting) => meeting.startDate, "desc");
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
  getCategorizedByDate: (state) => {
    return _.groupBy(state.meetings, (n: Meeting) =>
      n.startDate.toDateString()
    );
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
