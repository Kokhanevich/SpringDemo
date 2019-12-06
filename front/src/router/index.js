import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from "../views/Home";
import Registration from "../views/Registration";
import Login from '../views/Login.vue';
import Register from '../views/Register.vue'
import Profile from '../views/Profile'
import BoardUser from "../views/BoardUser";
import AdminBoard from "../views/AdminBoard";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect: {
      name: "login"
    }
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/registration',
    name: 'registration',
    component: Registration
  },
  {
    path: '/register',
    name: 'register',
    component: Register
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/profile',
    name: 'profile',
    component: Profile
  },
  {
    path: '/user',
    name: 'user',
    component: BoardUser
  },
  {
    path: '/admin',
    name: 'admin',
    component: AdminBoard
  }
]

const router = new VueRouter({
  mode: 'history',

  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, from, next) => {
  const publicPages = ['/login', '/home', '/register', '/registration'];
  const authRequired = !publicPages.includes(to.path);
  const loggedIn = localStorage.getItem('user');

  // try to access a restricted page + not logged in
  if (authRequired && !loggedIn) {
    return next('/login');
  }

  next();
});

export default router
