<template>
  <div class="about">
    <h1>UsersList</h1>
<!--    <HelloWorld msg="Welcome to Your Vue.js App"/>-->
    <UsersList/>
  </div>
</template>

<script>
  import HelloWorld from "../components/HelloWorld";
  import UsersList from "../components/UsersList";
  export default {
    components: {
      UsersList,
      HelloWorld
    }

  }
</script>
