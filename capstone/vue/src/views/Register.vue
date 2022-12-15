<template>
  <div id="background">
    <div class="for-background">
      <br>
    </div> 
    <div class="login-box">
    <h2>Register An Account</h2>
    <form>
      <div class="user-box">
        <input id="username" type="text" name="" required="" v-model="user.username">
        <label for="username">Username</label>
      </div>
      <div class="user-box">
        <input id="password" type="password" name="" required="" v-model="user.password">
        <label for="password">Password</label>
      </div>
      <div class="user-box">
        <input id="confirmPassword" type="password" name="" required="" v-model="user.confirmPassword">
        <label for="confirmPassword">Confirm Password</label>
      </div>
      <label class="dropDown" for="role">Are you a DJ or a HOST</label>
          <select name="role" id="role" v-model="user.role">
            <option value="HOST">HOST</option>
            <option value="DJ">DJ</option>
          </select>
      <a href="#" v-on:click="register">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        Register
      </a>
    </form>
  </div>
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

#background {
  background-color: #A96BCB;
  background-image: linear-gradient(#4A007b, #9000BE, #A96BCB)
}

.for-background {
  height: 100vh;
  width: 100vw;
}

html {
  height: 100%;
}

body {
  margin:0;
  padding:0;
  font-family: sans-serif;
  background: linear-gradient(black, black);
}

.login-box {
  position: absolute;
  top: 50%;
  left: 50%;
  width: 400px;
  padding: 40px;
  transform: translate(-50%, -50%);
  background: rgba(0,0,0,.75);
  box-sizing: border-box;
  box-shadow: 0 15px 25px rgba(0,0,0,.6);
  border-radius: 10px;
}

.login-box h2 {
  margin: 0 0 30px;
  padding: 0;
  color: #fff;
  text-align: center;
}

.login-box .user-box {
  position: relative;
}

.login-box .user-box input {
  width: 100%;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  margin-bottom: 30px;
  border: none;
  border-bottom: 1px solid #fff;
  outline: none;
  background: transparent;
}

.login-box .user-box label {
  position: absolute;
  top:0;
  left: 0;
  padding: 10px 0;
  font-size: 16px;
  color: #fff;
  pointer-events: none;
  transition: .5s;
}

.login-box .user-box input:focus ~ label,
.login-box .user-box input:valid ~ label {
  top: -20px;
  left: 0;
  color: #ED50FF;
  font-size: 12px;
}

.login-box form a {
  position: relative;
  display: inline-block;
  padding: 10px 20px;
  color: #ED50FF;
  font-size: 16px;
  text-decoration: none;
  text-transform: uppercase;
  overflow: hidden;
  transition: .5s;
  margin-top: 40px;
  letter-spacing: 4px
}

.login-box a:hover {
  background: #ED50FF;
  color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 5px #ED50FF,
              0 0 25px #ED50FF,
              0 0 50px #ED50FF,
              0 0 100px #ED50FF;
}

.login-box a span {
  position: absolute;
  display: block;
}

.login-box a span:nth-child(1) {
  top: 0;
  left: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(90deg, transparent, #ED50FF);
  animation: btn-anim1 1s linear infinite;
}

@keyframes btn-anim1 {
  0% {
    left: -100%;
  }
  50%,100% {
    left: 100%;
  }
}

.login-box a span:nth-child(2) {
  top: -100%;
  right: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(180deg, transparent, #ED50FF);
  animation: btn-anim2 1s linear infinite;
  animation-delay: .25s
}

@keyframes btn-anim2 {
  0% {
    top: -100%;
  }
  50%,100% {
    top: 100%;
  }
}

.login-box a span:nth-child(3) {
  bottom: 0;
  right: -100%;
  width: 100%;
  height: 2px;
  background: linear-gradient(270deg, transparent, #ED50FF);
  animation: btn-anim3 1s linear infinite;
  animation-delay: .5s
}

@keyframes btn-anim3 {
  0% {
    right: -100%;
  }
  50%,100% {
    right: 100%;
  }
}

.login-box a span:nth-child(4) {
  bottom: -100%;
  left: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(360deg, transparent, #ED50FF);
  animation: btn-anim4 1s linear infinite;
  animation-delay: .75s
}

@keyframes btn-anim4 {
  0% {
    bottom: -100%;
  }
  50%,100% {
    bottom: 100%;
  }
}

.dropDown {
  color: white;
}




/* #login {
  display: flex;
  height: 100vh;
  height: 35rem;
  justify-content: center;
      
}

#login {
  padding-top: 0px;
  background-color: rgba(144, 0, 190, .2);
  border-radius: 5px;
  padding: 5vh 1rem 1rem 1rem;
}

#login h1 {
  margin-bottom: 2rem;
  font-family: sans-serif;
}

form {
  padding-right: 20px;
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
} */

</style>
  

