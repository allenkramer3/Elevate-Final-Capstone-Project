<template>
  <div id="app">
  
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
  background-color: #4098FF;
  font-family: "Gill Sans", sans-serif;
   
}
a{
  color: #ffffff;
}

div {
background-image: url("./images/Elevate.png");
background-size: 80%;
background-size: contain;
background-repeat: no-repeat


}
  

</style>

