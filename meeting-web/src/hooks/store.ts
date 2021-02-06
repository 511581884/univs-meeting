import { computed } from "vue";
import { useStore as baseUseStore } from "vuex";

import { key } from "@/store";
import { Meeting } from "@/types";

export const useStore = () => baseUseStore(key);

export const useMeetings = () => {
  const store = useStore();
  return computed<Meeting[]>(() => store.state.meeting.meetings);
};
