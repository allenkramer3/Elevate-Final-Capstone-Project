<template>
  <div class="app">
  
    <div class="header">
      <img class="logo" src="./assets/Elevate_Logo.png"/>
      <button class="btn">
        <router-link class="btn-header" v-bind:to="{ name: 'home' }">Home</router-link>
      </button>
      <button class="btn">
        <router-link class="btn-header" v-bind:to="{ name: 'login'}">Login</router-link>
      </button>
      <button class="btn">
        <router-link class="btn-header" v-bind:to="{ name: 'register'}">Register</router-link>
      </button>
      <button class="btn">
        <router-link class="btn-header" v-bind:to="{ name: 'events'}">Events</router-link>
      </button>
      <button class="btn">
        <router-link class="btn-header" v-bind:to="{ name: 'dj'}">Dj</router-link>
      </button>
      <router-link class="btn-header" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>

    

    <div class="wrap">
   <div class="search">
      <input type="text" class="searchTerm" placeholder="Type an event">
      <button type="submit" class="searchButton">
        <i class="fa fa-search"></i>
     </button>
   </div>
</div>

    <div class="main-body">
      <router-view />
    </div>

    <div class="footer">
      <p> &copy; 2022 - Elevate by Zack, Alex, Allen, Jae and Krista</p>
    </div> 

    
  </div>
</template>


<style scoped>

@import url(https://fonts.googleapis.com/css?family=Open+Sans);
@import url(https://fonts.googleapis.com/css?family=Audiowide);

body{
  background: #f2f2f2;
  font-family: 'Open Sans', sans-serif;
}

.search {
  width: 100%;
  position: relative;
  display: flex;
}

.searchTerm {
  width: 100%;
  border: 3px solid #4098FF;
  border-right: none;
  padding: 5px;
  height: 20px;
  border-radius: 5px 0 0 5px;
  outline: none;
  color: #9DBFAF;
}

.searchTerm:focus{
  color: #4098FF;
}

.searchButton {
  width: 40px;
  height: 36px;
  border: 1px solid #4098FF;
  background: #4098FF;
  text-align: center;
  color: #fff;
  border-radius: 0 5px 5px 0;
  cursor: pointer;
  font-size: 20px;
}

.wrap{
  width: 50%;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.header {
  grid-area: header;
  background: black;
}

.main-body {
  grid-area: main-body;
}

.footer {
  grid-area: footer;
}

.app {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  grid-template-areas:
    "header header header"
    "main-body main-body main-body"
    "footer footer footer";
  height: 100vh;
  gap: 0px;
}

.logo {
  margin-bottom: 0px;
  height: 200px;
  width: auto;
}

.btn {
  padding: 0.6em 2em;
  border: none;
  margin: 30px;
  outline: none;
  color: rgb(255, 255, 255);
  background: #111;
  cursor: pointer;
  position: relative;
  z-index: 0;
  border-radius: 10px;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
}

.btn:before {
  content: "";
  background: linear-gradient(
    45deg,
    #ff0000,
    #ff7300,
    #fffb00,
    #48ff00,
    #00ffd5,
    #002bff,
    #7a00ff,
    #ff00c8,
    #ff0000
  );
  position: absolute;
  top: -2px;
  left: -2px;
  background-size: 400%;
  z-index: -1;
  filter: blur(5px);
  -webkit-filter: blur(5px);
  width: calc(100% + 4px);
  height: calc(100% + 4px);
  animation: glowing-button 20s linear infinite;
  transition: opacity 0.3s ease-in-out;
  border-radius: 10px;
}

@keyframes glowing-button {
  0% {
    background-position: 0 0;
  }
  50% {
    background-position: 400% 0;
  }
  100% {
    background-position: 0 0;
  }
}

.btn:after {
  z-index: -1;
  content: "";
  position: absolute;
  width: 100%;
  height: 100%;
  background: #222;
  left: 0;
  top: 0;
  border-radius: 10px;
}

.btn-header {
  text-decoration: none;
  color: white;
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
}
.app {
   background-color: white;
   height: 100vh; 
 }
  
</style>

