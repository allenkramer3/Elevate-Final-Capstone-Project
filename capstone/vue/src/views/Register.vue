<template>
  <!-- <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
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
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <router-link :to="{ name: 'login' }">Have an account?</router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
    </form>
  </div> -->

  <div id="login">
    <form>
          <h1>Create an Account</h1>
  
          <label for="email2">Username</label>
          <input type="text" placeholder="Create Username" id="email2" v-model="user.username">
  
          <label for="password2">Password</label>
          <input
            type="password"
            placeholder="Create Password"
            id="password2"
            v-model="user.password"
          >
  
          <label for="password3">Confirm Password</label>
          <input
            type="password"
            placeholder="Confirm Password"
            id="password3"
            v-model="user.confirmPassword"
          >

          <label for="role">Are you a DJ or a Host</label>
          <select name="role" id="role" v-model="user.role">
            <option value="HOST">Host</option>
            <option value="DJ">DJ</option>
          </select>
  
          <div class="form-actions">
            <button class="btn" v-on:click="register">Sign Up</button>
          </div>
          
        </form>
  </div>

</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: '',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
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
       height: 200px;
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
      select{
        margin: 10px;
      }

</style>
  

