<template>
  <div class="home">
    <h1 style="text-align:center">Welcome to Elevate.</h1>
    <h2 style="text-align:center">If you are an Elevate Host or DJ, please login below.</h2>
    <button class="home-nav">
      <router-link class="link-nav" v-bind:to="{ name: 'login'}">Login</router-link>
    </button>
    <h2 style="text-align:center">If you want to register as an Elevate DJ or Host, please register below.</h2>
    <button class="home-nav">
      <router-link v-bind:to="{ name: 'register'}">Register</router-link>
    </button>
    <h2 style="text-align:center">Feel free to view any of our events by clicking on the events link below.</h2>
    <button class="home-nav">
      <router-link v-bind:to="{ name: 'events'}">Events</router-link>
    </button>
    <img src="../assets/Club.png" alt="Club" class="center">
    <div class="wrap">
      <div class="search">
        <img class="search-icon" src="data:image/svg+xml;utf8;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pgo8IS0tIEdlbmVyYXRvcjogQWRvYmUgSWxsdXN0cmF0b3IgMTkuMC4wLCBTVkcgRXhwb3J0IFBsdWctSW4gLiBTVkcgVmVyc2lvbjogNi4wMCBCdWlsZCAwKSAgLS0+CjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgdmVyc2lvbj0iMS4xIiBpZD0iQ2FwYV8xIiB4PSIwcHgiIHk9IjBweCIgdmlld0JveD0iMCAwIDU2Ljk2NiA1Ni45NjYiIHN0eWxlPSJlbmFibGUtYmFja2dyb3VuZDpuZXcgMCAwIDU2Ljk2NiA1Ni45NjY7IiB4bWw6c3BhY2U9InByZXNlcnZlIiB3aWR0aD0iMTZweCIgaGVpZ2h0PSIxNnB4Ij4KPHBhdGggZD0iTTU1LjE0Niw1MS44ODdMNDEuNTg4LDM3Ljc4NmMzLjQ4Ni00LjE0NCw1LjM5Ni05LjM1OCw1LjM5Ni0xNC43ODZjMC0xMi42ODItMTAuMzE4LTIzLTIzLTIzcy0yMywxMC4zMTgtMjMsMjMgIHMxMC4zMTgsMjMsMjMsMjNjNC43NjEsMCw5LjI5OC0xLjQzNiwxMy4xNzctNC4xNjJsMTMuNjYxLDE0LjIwOGMwLjU3MSwwLjU5MywxLjMzOSwwLjkyLDIuMTYyLDAuOTIgIGMwLjc3OSwwLDEuNTE4LTAuMjk3LDIuMDc5LTAuODM3QzU2LjI1NSw1NC45ODIsNTYuMjkzLDUzLjA4LDU1LjE0Niw1MS44ODd6IE0yMy45ODQsNmM5LjM3NCwwLDE3LDcuNjI2LDE3LDE3cy03LjYyNiwxNy0xNywxNyAgcy0xNy03LjYyNi0xNy0xN1MxNC42MSw2LDIzLjk4NCw2eiIgZmlsbD0iIzAwMDAwMCIvPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8Zz4KPC9nPgo8L3N2Zz4K" />
        <input type="text" class="searchTerm" placeholder="Type an event">
        <button type="submit" class="searchButton">
          <i class="fa fa-search"></i>
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style scoped>
  .home {
  background-image: linear-gradient(#000200, #4A007b, #9000BE, #A96BCB);
  height: 100vh;
  }

  h1 {
    color: rgb(216, 216, 216);
    text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
    font-style: italic;
    font-family: "Audiowide", sans-serif;
    padding-top: 10px;
  }

  .center {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
  border: 3px solid #4098FF;
}

   h2 {
    color: white;
    text-shadow: 0 0 20px #ff00d4, 0 0 5px #ff00b3;
    font-style: oblique;
  }
  
  .wrap{
  width: 50%;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

.search {
  width: 100%;
  position: relative;
  display: flex;
}

.searchTerm {
  position:relative;  
  left:13%;
  top:25%;
  width:30%;
  width: 75%;
  border: 3px solid #4098FF;
  border-right: none;
  padding: 5px;
  height: 20px;
  border-radius: 5px 0 0 5px;
  outline: none;
  color: #9DBFAF;
}

 .search-icon {
    position: absolute;
    top: 10px;
    left: 635px;
    width: 14px;
    
  }

.searchTerm:focus{
  color: #000000;
  
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

.btn {
  /*background-color: #4098FF; */
  margin: 0;
  position: absolute;
  left: 45%;
  border-radius: 6px; 
  border: none;
  color: rgb(0, 0, 0);
  padding: 5px 9px;
  font-size: 14px;
}

.link-nav {
  margin: auto;
}


</style>
