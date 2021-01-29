import { createApp } from "vue";
import App from "./App.vue";
import "vant/lib/index.css";
import Vuex from "vuex";

createApp(App)
  .use(Vuex)
  .mount("#app");
