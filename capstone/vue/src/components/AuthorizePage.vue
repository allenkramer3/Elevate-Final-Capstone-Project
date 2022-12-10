<template>
  <div>
      <h1>Test 123; add auth stuff in this component</h1>
      <h2>Click to get auth code</h2>
      <a v-on:click="getParams()" href="https://accounts.spotify.com/authorize?client_id=39164483b245448a9b0816a999571e93&redirect_uri=http://localhost:8080/dj/authorize&response_type=code&scope=user-modify-playback-state+user-read-playback-position+user-library-read+streaming+user-read-playback-state">Authorize</a>
        <br>
        <h3>Code: </h3>
        <h3 id="auth-code"> </h3>
  </div>
</template>

<script>
export default {
    name: "authorize-page",
    methods: {
        getParams (){

            let urlParam = new URLSearchParams(window.location.search);

            const h3 = document.querySelector("#auth-code");
            h3.innerHtml = urlParam;

        }
    }
}
</script>

<style>

</style>