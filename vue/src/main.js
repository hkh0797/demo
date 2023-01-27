import './assets/common.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import axios from 'axios'
import sidebar from 'vue-sidebar-menu'
import 'vue-sidebar-menu/dist/vue-sidebar-menu.css'

const app = createApp(App)

app.config.globalProperties.$axios = axios
app.config.globalProperties.$serverUrl = '//localhost:8080'

app.use(router).use(sidebar).mount('#app')
