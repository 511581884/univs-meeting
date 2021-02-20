import {
  UserActions,
  UserGetters,
  UserMutations,
  UserState,
  UserStore
} from "@/types";
import { getUser } from "@/api/user"

const state: UserState = {
  user: {
    id: 0,
    name: "",
    department: {
      id: 0,
      name: ""
    },
    avatarUrl: ""
  }
};

const mutations: UserMutations = {
  updateUser(state, user){
    state.user = user
  }
};

const actions: UserActions = {
  fetchUser: async ({ commit }) => {
    const user = await getUser();
    commit("updateUser", user);
  }
};

const getters: UserGetters = {
  getUser: (state)=>{
    return state.user
  }
};

const userStore: UserStore = {
  namespaced: true,
  state,
  actions,
  mutations,
  getters,
};

export default userStore;
