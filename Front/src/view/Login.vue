<template>
  <div class="htmleaf-container">
    <alert :show.sync=showflag :content.sync=content></alert>
    <div class="wrapper">
      <div class="container1" :class="{show1:showtest1}">
        <h1>Welcome</h1>
        <form class="form">
          <input type="text" v-model="username" placeholder="Username">
          <input type="password" v-model="password" placeholder="Password">
          <button type="submit"  @click="login()">Login</button>
          <br>
          <p @click="toregister()">No account? Click Register</p>
        </form>
      </div>
      <div class="container2" :class="{show2:showtest2}">
        <h1>Register account</h1>
        <form class="form">
          <input type="text" v-model="username" placeholder="Username">
          <input type="password" v-model="password" placeholder="Password">
          <input type="password" v-model="again" placeholder="Input your password again">
          <button type="submit" id="login-button" @click="register()">Register</button>
          <br>
          <p @click="back()">Regret it? Click Register</p>
        </form>
      </div>
      <ul class="bg-bubbles">
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
      </ul>
    </div>
  </div>

</template>

<script>
import axios from 'axios'
import alert from "@/components/Alert"
export default {
  name: "login",
  data() {
    return {
      username: '',
      password: '',
      again:'',
      content: '',
      showflag: false,
      showtest1: false,
      showtest2: false
    }
  },
  components: {
    alert
  },
  methods: {
    login() {
      var user = {username:this.username, password:this.password}
      var that = this
      axios
          .post("http://xcyzz.vipgz4.idcfengye.com/login/login", user)
      .then(function (response) {
        if(response.data == "Wrong password") {
          that.content = "密码错误"
          that.showflag = true
        } else {
          that.content = "登录成功"
          that.showflag = true
          that.$store.state.username = that.username
          that.$router.replace("/homepage")
        }
      })
      .catch(function (error) {
        console.log(error)
      });
   },
    register:function () {
      var that = this
      if (this.again == this.password ) {
        var user = {username:this.username, password:this.password}
        axios
            .post("http://xcyzz.vipgz4.idcfengye.com/login/register", user)
            .then(function (response) {
              if (response.data == "repeat of user name") {
                that.content = "用户名已存在"
                that.showflag = true
              } else {
                console.log(response)
                that.content = "注册成功"
                that.showflag = true
                that.showtest1 = false
                that.showtest2 = false
              }
            })
            .catch(function (error) {
              console.log(error)
            })
      } else {
        this.content = "两次输入密码不一致"
        this.showflag = true
      }
    },
    toregister() {
      this.username = ''
      this.password = ''
      this.showtest1 = true
      this.showtest2 = true
   },
    back(){
     this.username = ''
     this.password = ''
     this.showtest2 = false
     this.showtest1 = false
   }
  }
}
</script>

<style scoped>
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  font-weight: 300;
}
body {
  font-family: 'Source Sans Pro', sans-serif;
  color: white;
  font-weight: 300;
}
.wrapper {
  background: #50a3a2;
  background: -webkit-linear-gradient(top left, #50a3a2 0%, #53e3a6 100%);

  opacity: 0.8;
  position: absolute;
  top: 50%;
  left: 0;
  width: 100%;
  height: 400px;
  margin-top: -200px;
  overflow: hidden;
}
/*.wrapper.form-success .container h1 {*/
/*  transform: translateY(85px);*/
/*}*/
.container1 {
  z-index: 5;
  width: 400px;
  max-width: 600px;
  position:absolute;
  left:50%;
  top:50%;
  transform:translate(-50%,-50%);
  padding: 80px 0;
  height: 400px;
  text-align: center;
  transition: all 1s ease;
  opacity: 1;
}
.container2 {
  z-index: 4;
  width: 400px;
  max-width: 600px;
  position:absolute;
  left:50%;
  top:50%;
  transform:translate(-50%,-50%);
  padding: 80px 0;
  height: 400px;
  text-align: center;
  transition: all 0.5s ease;
  opacity: 0;
 }
.show1{
  opacity: 0;
  z-index: 4;
 }
.show2{
  opacity: 1;
  z-index: 5;
}
.container1 h1 {
  font-size: 40px;
  transition-duration: 1s;
  font-weight: 200;
}
.container2 h1 {
  font-size: 40px;
  transition-duration: 1s;
  font-weight: 200;
}
form {
  padding: 20px 0;
  position: relative;
  z-index: 2;
}
form input {
  appearance: none;
  outline: 0;
  border: 1px solid rgba(255, 255, 255, 0.4);
  background-color: rgba(255, 255, 255, 0.2);
  width: 250px;
  border-radius: 3px;
  padding: 10px 15px;
  margin: 0 auto 10px auto;
  display: block;
  text-align: center;
  font-size: 18px;
  transition-duration: 0.25s;
  font-weight: 300;
}
form input:hover {
  background-color: rgba(255, 255, 255, 0.4);
}
form input:focus {
  background-color: white;
  width: 300px;
  color: #53e3a6;
}
form button {
  appearance: none;
  outline: 0;
  background-color: white;
  border: 0;
  padding: 10px 15px;
  color: #53e3a6;
  border-radius: 3px;
  width: 250px;
  cursor: pointer;
  font-size: 18px;
  transition-duration: 0.25s;
}
form button:hover {
  background-color: #f5f7f9;
}
form p {
  color: #f5f7f9;
  cursor: pointer;
}
.bg-bubbles {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 1;
}
.bg-bubbles li {
  position: absolute;
  list-style: none;
  display: block;
  width: 40px;
  height: 40px;
  background-color: rgba(255, 255, 255, 0.15);
  bottom: -160px;
  animation: square 25s infinite;
  transition-timing-function: linear;
}
.bg-bubbles li:nth-child(1) {
  left: 10%;
}
.bg-bubbles li:nth-child(2) {
  left: 20%;
  width: 80px;
  height: 80px;
  animation-delay: 2s;
  animation-duration: 17s;
}
.bg-bubbles li:nth-child(3) {
  left: 25%;
  animation-delay: 4s;
}
.bg-bubbles li:nth-child(4) {
  left: 40%;
  width: 60px;
  height: 60px;
  animation-duration: 22s;
  background-color: rgba(255, 255, 255, 0.25);
}
.bg-bubbles li:nth-child(5) {
  left: 70%;
}
.bg-bubbles li:nth-child(6) {
  left: 80%;
  width: 120px;
  height: 120px;
  animation-delay: 3s;
  background-color: rgba(255, 255, 255, 0.2);
}
.bg-bubbles li:nth-child(7) {
  left: 32%;
  width: 160px;
  height: 160px;
  animation-delay: 7s;
}
.bg-bubbles li:nth-child(8) {
  left: 55%;
  width: 20px;
  height: 20px;
  animation-delay: 15s;
  animation-duration: 40s;
}
.bg-bubbles li:nth-child(9) {
  left: 25%;
  width: 10px;
  height: 10px;
  animation-delay: 2s;
  animation-duration: 40s;
  background-color: rgba(255, 255, 255, 0.3);
}
.bg-bubbles li:nth-child(10) {
  left: 90%;
  width: 160px;
  height: 160px;
  animation-delay: 11s;
}
@keyframes square {
  0% {
    -ms-transform: translateY(0);
    -moz-transform: translateY(0);
    transform: translateY(0);
  }
  100% {
    -ms-transform: translateY(-700px) rotate(600deg);
    -moz-transform: translateY(-700px) rotate(600deg);
    transform: translateY(-700px) rotate(600deg);
  }
}
</style>