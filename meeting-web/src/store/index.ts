import { InjectionKey } from "vue";
import { createStore } from "vuex";

import meetingStore from "./modules/meeting";
import notificationStore from "./modules/notification";
import userStore from "./modules/user";

import { RootStore } from "@/types";

export const key: InjectionKey<RootStore> = Symbol();

export default createStore({
  modules: {
    meeting: meetingStore,
    notification: notificationStore,
    user: userStore
  },
});
