<!--<template>-->
<!--  <div id="app">-->
<!--    <div id="nav">-->
<!--      <router-link to="/">Home</router-link> |-->
<!--      <router-link to="/about">About</router-link>-->
<!--      <router-link to="/register">  Registration</router-link>-->
<!--    </div>-->
<!--    <transition-->
<!--            name="fade"-->
<!--            mode="out-in"-->
<!--    >-->
<!--      <router-view/>-->
<!--    </transition>-->
<!--&lt;!&ndash;    <router-view/>&ndash;&gt;-->
<!--  </div>-->
<!--</template>-->

<!--<style lang="scss">-->
<!--#app {-->
<!--  font-family: 'Avenir', Helvetica, Arial, sans-serif;-->
<!--  -webkit-font-smoothing: antialiased;-->
<!--  -moz-osx-font-smoothing: grayscale;-->
<!--  text-align: center;-->
<!--  color: #2c3e50;-->
<!--}-->

<!--#nav {-->
<!--  padding: 30px;-->

<!--  a {-->
<!--    font-weight: bold;-->
<!--    color: #2c3e50;-->

<!--    &.router-link-exact-active {-->
<!--      color: #42b983;-->
<!--    }-->
<!--  }-->
<!--}-->
<!--.fade-enter-active,-->
<!--.fade-leave-active {-->
<!--  transition-duration: 1s;-->
<!--  transition-property: opacity;-->
<!--  transition-timing-function: ease;-->
<!--}-->

<!--.fade-enter,-->
<!--.fade-leave-active {-->
<!--  opacity: 0-->
<!--}-->
<!--</style>-->

<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <a href="#" class="navbar-brand">MyApp</a>
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <a href="/home" class="nav-link">
            <font-awesome-icon icon="home" /> Home
          </a>
        </li>
        <li class="nav-item">
          <a href="/user" class="nav-link" v-if="currentUser">User</a>
        </li>
        <li class="nav-item" v-if="showAdminBoard">
          <a href="/admin" class="nav-link">Admin Board</a>
        </li>
        <li class="nav-item">
          <a href="/allUsers" class="nav-link" v-if="currentUser">All Users</a>
        </li>
      </div>

      <div class="navbar-nav ml-auto" v-if="!currentUser">
        <li class="nav-item">
          <a href="/register" class="nav-link">
            <font-awesome-icon icon="user-plus" /> Sign Up
          </a>
        </li>
        <li class="nav-item">
          <a href="/login" class="nav-link">
            <font-awesome-icon icon="sign-in-alt" /> Login
          </a>
        </li>
      </div>

      <div class="navbar-nav ml-auto" v-if="currentUser">
        <li class="nav-item">
          <a href="/profile" class="nav-link">
            <font-awesome-icon icon="user" />
            {{currentUser.username}}
          </a>
        </li>
        <li class="nav-item">
          <a href class="nav-link" @click="logOut">
            <font-awesome-icon icon="sign-out-alt" /> LogOut
          </a>
        </li>
      </div>
    </nav>

    <div class="container">
      <router-view />
    </div>
  </div>
</template>

<script>
  export default {
    computed: {
      currentUser() {
        return this.$store.state.auth.user;
      },
      showAdminBoard() {
        if (this.currentUser) {
          return this.currentUser.roles.includes('ADMIN');
        }

        return false;
      }
    },
    methods: {
      logOut() {
        this.$store.dispatch('auth/logout');
        this.$router.push('/login');
      }
    }
  }
</script>
