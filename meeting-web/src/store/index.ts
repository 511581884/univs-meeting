import { createStore } from "vuex";
import meetingStore from "./modules/meeting";
import notificationStore from "./modules/notification";

export default createStore({
  modules: {
    meeting: meetingStore,
    notification: notificationStore,
  },
});
