<template>
  <transition name="confirm-fade">
    <div v-if="show" class="confirm">
      <alert :show.sync=showflag :content.sync=content></alert>
      <div class="confirm-content-wrap">
        <p class="title">修改个人信息</p>
        <form class="form">
          <input type="text" v-model="information.sex" placeholder="性别">
          <input type="text" v-model="information.age" placeholder="年龄">
          <input type="text" v-model="information.college" placeholder="学院">
          <input type="text" v-model="information.classes" placeholder="专业班级">
          <div class="buttonbox">
            <button type="submit" @click="closeshow(information)">提交</button>
            <button type="submit" @click="close()">取消</button>
          </div>
        </form>
      </div>
    </div>
  </transition>
</template>

<script>
import alert from "@/components/Alert";
import axios from "axios";

export default {
  name: "changeinformation",
 data () {
    return {
      information:{
        username:'',
        sex: '',
        age: '',
        college: '',
        classes: '',
      },
      showflag: false,
      content: '',
      title: ''
    }
  },
  props: ['show'],
  components: {
    alert
  },
  methods: {
    closeshow () {
      var that = this
      this.information.username = this.$store.state.username
    axios.post("http://xcyzz.vipgz4.idcfengye.com/information/add", that.information)
        .then(function (response) {
          if(response.data == 1) {
            that.content = "提交成功"
            that.showflag = true
          } else {
            that.content = "提交失败"
            that.showflag = true
          }
        })
        .catch(function (error) {
          console.log(error)
          that.content = "提交失败"
          that.showflag = true
        })
     this.$emit("update:show",false);
  },
  close() {
    this.$emit("update:show",false);
  }
}
}
</script>

<style scoped>
<style scoped>
.buttonbox {
  display: flex;
  justify-content: space-between;
}
.title {
  display: flex;
  justify-content: center;
  font-family: 'Helvetica Neue', Helvetica, Arial, Sans-serif;
  font-size: 25px;
  color: grey;
}
.confirm {
  display: flex;
  align-items: center;
  justify-content: center;
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 1000;
}
.confirm-fade-enter-active {
  animation: opacity 0.3s;
}
.confirm-fade-enter-active .confirm-content-wrap {
  animation: scale 0.3s;
}
.confirm-fade-leave-active {
  animation: outOpacity 0.2s;
}
.confirm-content-wrap {
  position: absolute;
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 10px;
  width: 280px;
  margin: 0 auto;
  background-color: #fff;
  border-radius: 5px;
  z-index: 999;
  user-select: none;
  overflow: hidden;
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
  letter-spacing: 10px;
  background-color: #53e3a6;
  color: white;
}
form textarea {
  appearance: none;
  outline: 0;
  border: 1px solid rgba(255, 255, 255, 0.4);
  background-color: rgba(255, 255, 255, 0.2);
  color: grey;
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
form textarea:hover {
  background-color: rgba(255, 255, 255, 0.4);
}
form textarea:focus {
  letter-spacing: 10px;
  background-color: #53e3a6;
  color: white;
}
form button {
  appearance: none;
  outline: 0;
  background-color: white;
  border: 0;
  padding: 10px 15px;
  color: #53e3a6;
  border-radius: 3px;
  width: 282px;
  cursor: pointer;
  font-size: 18px;
  transition-duration: 0.25s;
}
form button:hover {
  background-color: #f5f7f9;
}
@keyframes opacity {
  0% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}
@keyframes scale {
  0% {
    transform: scale(0);
  }
  60% {
    transform: scale(1.1);
  }
  100% {
    transform: scale(1);
  }
}
@keyframes outOpacity {
  0% {
    opacity: 1;
  }
  100% {
    opacity: 0;
  }
}
</style>