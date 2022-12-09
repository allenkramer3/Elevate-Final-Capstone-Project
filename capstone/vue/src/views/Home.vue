<template>
  <div class="home">
    <h1 style="text-align:center">Welcome to Elevate.</h1>
    <h2 style="text-align:center">Please log in or continue as a guest.</h2>
    <div class="guest-actions">
      <button class="btn">Continue as Guest</button>
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
  
</style>
