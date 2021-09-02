<template>
  <div class="setbox" :class="{show: showflag}">
    <div class="header">
      <form class="message">
        <button  @click="information()">个人信息</button>
        <button  @click="set()">委托列表</button>
        <button  @click="my()">我的委托</button>
        <button  @click="get()">我的接取</button>
        <button  @click="close">关闭</button>
      </form>

    </div>
  </div>
</template>

<script>
export default {
  name: "setbox",
  props:['showflag'],
  methods: {
    information() {
      this.$router.replace("/information")
    },
    set() {
      this.$router.replace("/homepage")
    },
    my() {
      this.$router.replace("/mytask")
    },
    close() {
      this.$emit("update:showflag",false)
    },
    get() {
      this.$router.replace("/get")
    }
  }
}
</script>

<style scoped>
.setbox{
  position:fixed;
  z-index:1000;
  top:0px;
  bottom:0px;
  width:250px;
  height:100%;
  background: #50a3a2;
  background: -webkit-linear-gradient(top left, #53e3a6 0%, #ffffff 100%);
  border-left: 1px solid #CFD8DC!important;
  box-shadow:0px 3px 12px rgba(0,0,0,0.12);
  -webkit-transition: all 0.3s ease;
  transition: all 0.3s ease;
  left:-460px;
  padding:0px 0px 0px 0px;
}
.show {
  left: 0;
}

form button{
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  outline: 0;
  background-color: rgba(255, 255, 255, 0.1);
  border: 1px solid rgba(255, 255, 255, 0.4);
  padding: 10px 15px;
  color: grey;
  width: 100%;
  cursor: pointer;
  font-size: 18px;
  -webkit-transition-duration: 0.25s;
  transition-duration: 0.25s;
}
form button:hover {
  background-color: white;
}
</style>