import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import DemoList from '@/views/demo/DemoList.vue'
import DemoDetail from '@/views/demo/DemoDetail.vue'
import DemoWrite from '@/views/demo/DemoWrite.vue'
import SampleList from '@/views/sample/SampleList.vue'
// import PoketmonList from '@/views/poketmon/PoketmonList.vue'
import TreeList from '@/views/tree/TreeList.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/demo/list',
    name: 'DemoList',
    component: DemoList
  },
  {
    path: '/demo/detail',
    name: 'DemoDetail',
    component: DemoDetail
  },
  {
    path: '/demo/write',
    name: 'DemoWrite',
    component: DemoWrite
  },
  {
    path: '/sample',
    name: 'SampleList',
    component: SampleList
  },
  // {
  //   path: '/poketmon',
  //   name: 'PoketmonList',
  //   component: PoketmonList
  // },
  {
    path: '/tree',
    name: 'TreeList',
    component: TreeList
  }
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router
