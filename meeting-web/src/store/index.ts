import { createStore } from "vuex";
import meetingStore from "./modules/meeting";
import notificationStore from "./modules/notification";

export default createStore({
  modules: {
    meeting: meetingStore,
    notification: notificationStore,
  },
});

// import notificationModule from "./modules/notification";

// const store = createStore({
//   state: () => {
//     return {
//       meetings: [],
//     };
//   },
//   mutations: {
//     updateMeetings(state, meetings) {
//       state.meetings = meetings;
//     },
//   },
//   actions: {
//     fetchMeetings: async ({ commit }) => {
//       const meetings = await getMeetings();
//       commit("updateMeetings", meetings);
//     },
//   },
//   getters: {
//     getMeetings(state) {
//       return _.sortBy(state.meetings, (meeting) => meeting.startDate);
//     },
//     datesHaveMeeting(state) {
//       const dates = state.meetings.map(({ startDate }) => ({
//         year: startDate.getFullYear(),
//         month: startDate.getMonth(),
//         date: startDate.getDate(),
//       }));

//       const unique = _.uniqWith(dates, _.isEqual);
//       return unique.map((date) => new Date(date.year, date.month, date.date));
//     },
//   },
//   modules: {
//     notification: notificationModule,
//   },
// });

// export default store;
