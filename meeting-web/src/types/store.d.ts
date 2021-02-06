import {
  Mutation,
  MutationTree,
  Action,
  ActionTree,
  Getter,
  GetterTree,
  Module,
  ModuleTree,
  Store,
} from "vuex";
import { Meeting, Notification } from "@/types";
import { NotificationType } from "./notification";

export interface RootStore extends Store<RootStore> {
  [x: string]: any;
  modules: RootModules;
}

export interface RootModules extends ModuleTree<RootStore> {
  meeting: Module<MeetingState, RootStore>;
  notification: Module<NotificationState, RootStore>;
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
  getMeetingsByDate: Getter<MeetingState, RootStore>;
  datesHaveMeeting: Getter<MeetingState, RootStore>;
}

export interface MeetingStore extends Module<MeetingState, RootStore> {}

export interface NotificationState {
  notifications: NotificationType[];
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
