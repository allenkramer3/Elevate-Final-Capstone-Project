<template>
  <div class="home">
    <h1 style="text-align:center">Welcome to Elevate.</h1>
    <h2 style="text-align:center">Please log in or continue as a guest.</h2>
    <img src="nightclub.jpg" alt="Paris" class="center">

    <div class="guest-actions">
      <button class="btn">Continue as Guest</button>
    </div>
    <div class="wrap">
      <div class="search">
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
  background-color: #4098FF;
  margin: 0;
  position: absolute;
  left: 45%;
  border-radius: 6px; 
  border: none;
  color: white;
  padding: 5px 9px;
  font-size: 14px;
}

.center {
  display: block;
  margin-left: auto;
  margin-right: auto;
  width: 50%;
}
</style>
