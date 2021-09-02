<template>
  <transition name="confirm-fade">
    <div v-if="show" class="confirm">
      <div class="confirm-content-wrap">
        <p class="title">来自陌生人的委托</p>
        <form class="form">
          <p>委托标题：{{title}}</p>
          <p>委托内容：{{content}}</p>
          <p>报酬：{{repay}}</p>
          <div class="buttonbox">
            <button type="submit" @click="change(title)">接取</button>
            <button type="submit" @click="close(title)">取消</button>
          </div>
        </form>
      </div>
    </div>
  </transition>
</template>

<script>
import axios from "axios";

export default {
  name: "showform",
  props: ['show','username','title','content','repay'],

  methods: {
    change(test) {
      var that = this
      var task = {title:test, user2:this.$store.state.username}
      axios.post('http://xcyzz.vipgz4.idcfengye.com/homepage/changetask', task)
          .then(function () {
            that.$emit('update:show',false)
          })
    },
    close(test) {
      var that = this
      var task = {title:test}
      axios.post('http://xcyzz.vipgz4.idcfengye.com/homepage/plustemp', task)
          .then(function () {
            that.$emit('update:show',false)
          })
    }
  },
}
</script>

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
  background-color: #53e3a6;
  width: 300px;
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