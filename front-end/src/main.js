import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import './plugins/bootstrap-vue'
import App from './App.vue'
import router from './router'

// Import Bootstrap an BootstrapVue CSS files (order is important)
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(VueAxios, axios)
axios.defaults.baseURL='http://localhost:8080/api/'
axios.defaults.headers= {
  Accept:"application/json",
      "Content-type":"application/json",
      "Access-Control-Allow-Origin":"*",
}
axios.defaults.withCredentials =false


// Make BootstrapVue available throughout your project
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)

Vue.config.productionTip = false

Vue.prototype.$appname = 'GT Clínica'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'








new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
