import {
  Mutation,
  MutationTree,
  Action,
  ActionTree,
  Getter,
  GetterTree,
  Module,
} from "vuex";
import { Meeting, Notification } from "@/types";

export interface RootStore {
  modules: {
    meeting: Module<MeetingState, RootStore>;
  };
}

export interface MeetingState {
  meetings: Meeting[];
}
export interface MeetingMutations extends MutationTree<MeetingState> {
  updateMeetings: Mutation<MeetingState>;
}

export interface MeetingActions extends ActionTree<MeetingState, RootStore> {
  fetchMeetings: Action<MeetingState, RootStore>;
}
export interface MeetingGetters extends GetterTree<MeetingState, RootStore> {
  getMeetings: Getter<MeetingState, RootStore>;
  datesHaveMeeting: Getter<MeetingState, RootStore>;
}

export interface MeetingStore extends Module<MeetingState, RootStore> {}

export interface NotificationState {
  notifications: Notification[];
  length: number;
}
export interface NotificationMutations extends MutationTree<NotificationState> {
  updateNotifications: Mutation<NotificationState>;
  makeAllRead: Mutation<NotificationState>;
}

export interface NotificationActions
  extends ActionTree<NotificationState, RootStore> {
  fetchNotifications: Action<NotificationState, RootStore>;
  makeAllRead: Action<NotificationState, RootStore>;
}
export interface NotificationGetters
  extends GetterTree<NotificationState, RootStore> {
  getTopThreeNotifications: Getter<NotificationState, RootStore>;
  getUnreadAmount: Getter<NotificationState, RootStore>;
  getCategorizedByDate: Getter<NotificationState, RootStore>;
}

export interface NotificationStore
  extends Module<NotificationState, RootStore> {}
