<template>
  <!-- <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <button type="submit">Sign in</button>
    </form>
  </div> -->

  <div id="login">
      <!-- <section id="content">
        <img class="logo">
        <h1>Elevate</h1>
        <p>Elevate your party!</p>
      </section> -->
      <section id="login">
        <form>
          <h1>Please log in to your account</h1>
  
          <label for="email">Username</label>
          <input
            type="text"
            placeholder="Username"
            id="email"
          >
  
          <label for="password">Password</label>
          <input
            type="password"
            placeholder="Password"
            id="password"
          >
  
          <div class="form-actions">
            <button class="btn">Log In</button>
            <div class="extras">
              <a>Create an Account</a>
            </div>
          </div>
        </form>
  
        <!-- <form>
          <h1>Create an Account</h1>
  
          <label for="email2">Username</label>
          <input type="text" placeholder="Create Username" id="email2">
  
          <label for="password2">Password</label>
          <input
            type="password"
            placeholder="Create Password"
            id="password2"
          >
  
          <label for="password3">Confirm Password</label>
          <input
            type="password"
            placeholder="Confirm Password"
            id="password3"
          >
  
          <div class="form-actions">
            <button class="btn">Sign Up</button>
            <div class="extras">
              <a>Back to Login</a>
            </div>
          </div>
          <div class="guest-actions">
            <button class="btn">Continue as Guest</button>
          </div>
        </form> -->
      </section>
    </div>

</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>

  #login {
       display: flex;
       height: 100vh;
       /* flex-direction: column; */
       height: 35rem;
       justify-content: center;
       /* margin: 4rem auto; */
       
      }
      .logo {
       /* height: 200px; */
       width: auto;
       padding-bottom: 10px;
       filter: grayscale(100%);
       padding-top: 20px;
      }
      #content {
       background-color: #496bcb;
       color: #fff;
      }
      #login {
       padding-top: 0px;
      }
      #login {
       background-color: #fcfcfc;
      }
      #content,
      #login {
       padding: 5vh 1rem 1rem 1rem;
      }
      #content h1,
      #login h1 {
       margin-bottom: 2rem;
       font-family: sans-serif;
      }
      #content h1 {
       font-size: 3rem;
      }
      form h1 {
       margin-left: 0;
      }
      form label {
       font-size: 1rem;
       margin-bottom: 0.5rem;
      }
      form input {
       width: 100%;
       margin-bottom: 1rem;
       padding: 10px;
       border: 1px solid #e6ecf0;
       border-radius: 3px;
      }
      form label,
      form input {
       display: block;
      }
      form button {
       padding: 0.8rem 1rem;
       color: #000;
       border-radius: 3px;
      }
      .form-actions {
       display: flex;
      }
      .form-actions .extras {
       flex: 2;
      }
      .form-actions .extras {
       text-align: right;
       align-self: center;
      }
     
       #content > *,
       #login-signup form {
       max-width: 80%;
       margin: 0 auto;
       }
      a {
       cursor: pointer;
      }
      .btn {
        cursor: pointer;
      }
</style>
