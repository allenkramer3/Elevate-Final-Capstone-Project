<template>
  <div id="app">
    <img alt="Elevate logo" src="./images/Elevate.png" />'
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>


<style scoped>
#app {
   background-color: #000000;
   height: 100vh;
}
#nav{
  background-color: #4A007B;
  font-family: "Audiowide", sans-serif;
   
}
a{
  color: #090531;
}

main {
  background-image: url(./Images);
}
</style>
