import Vue from 'vue'
import App from './App.vue'

import router from "@/router"
import vuetify from "@/vuetify";
import axios from "axios";
import store from "@/store"
Vue.config.productionTip = false

axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8';
new Vue({
  router,
  vuetify,
  store,
  render: h => h(App),

}).$mount('#app')
