import { createApp } from 'vue';
import App from './App.vue';

import 'amfe-flexible';
import "vant/lib/index.css";

import store from "./store";
import router from "./router";
import "./assets/fonts/index.css";
import "./assets/styles/variables.css";

createApp(App)
  .use(store)
  .use(router)
  .mount("#app");
