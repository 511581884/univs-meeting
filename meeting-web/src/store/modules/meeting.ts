import _ from "lodash";

import {
  Meeting,
  MeetingState,
  MeetingMutations,
  MeetingActions,
  MeetingGetters,
  MeetingStore,
} from "@/types";
import { getMeetings } from "@/api/meeting";
import { areSameDate, isInThisWeek } from "@/helpers/dateTime";

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
    const data = await getMeetings();

    //Dates are represented as 'strings' in the data coming from the backend.
    //Convert date string to date object.
    data.forEach((meeting) => {
      meeting.startDate = new Date(meeting.startDate);
      meeting.endDate = new Date(meeting.endDate);
    });

    commit("updateMeetings", data);
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
    const dates = state.meetings.map(({ startDate }) => {
      return {
        year: startDate.getFullYear(),
        month: startDate.getMonth(),
        date: startDate.getDate(),
      };
    });
    const unique: typeof dates = _.uniqWith(dates, _.isEqual);
    return unique.map(({ year, month, date }) => new Date(year, month, date));
  },

  getCategorizedByDate: (state) => {
    return _.groupBy(state.meetings, (n: Meeting) =>
      n.startDate.toDateString()
    );
  },
  getMeetingsOfThisWeek: (state) => {
    return state.meetings.filter((item) => {
      return isInThisWeek(item.startDate);
    });
  },
  getMeetingByMeetingId: (state) => (id) => {
    return state.meetings.find((item) => {
      return item.id === Number(id);
    });
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
