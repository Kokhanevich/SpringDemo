<!--<template>-->
<!--  <div class="home">-->
<!--    <img alt="Vue logo" src="../assets/logo.png">-->
<!--    <HelloWorld msg="Welcome to Your Vue.js App"/>-->
<!--  </div>-->
<!--</template>-->

<!--<script>-->
<!--// @ is an alias to /src-->
<!--import HelloWorld from '@/components/HelloWorld.vue'-->
<!--import {allUsers} from "../api/UserRepository";-->

<!--export default {-->
<!--  name: 'home',-->
<!--  components: {-->
<!--    HelloWorld-->
<!--  },-->
<!--  data() {-->
<!--    return {-->
<!--      users: []-->
<!--    }-->

<!--  },-->
<!--}-->
<!--</script>-->
<template>
  <div class="container">
    <header class="jumbotron">
      <h3>{{content}}</h3>
    </header>
  </div>
</template>

<script>
  import UserService from '../api/user.service';

  export default {
    name: 'home',
    data() {
      return {
        content: ''
      };
    },
    mounted() {
      UserService.getPublicContent().then(
              response => {
                this.content = response.data;
              },
              error => {
                this.content = error.response.data.message;
              }
      );
    }
  };
</script>
