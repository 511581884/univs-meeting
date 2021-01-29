import { createStore } from "vuex";

const storeConfig = {
  state() {
    return {
      counter: 0,
    };
  },
  mutations: {
    changeCounter(state, payload) {
      state.counter += payload.value;
    },
  },
  actions: {
    changeCounter(context) {
      //May have some async operations here...
      context.commit("changeCounter");
    },
  },
  modules: {},
};

const store = createStore(storeConfig);

export default store;
