<template>
  <div class="alert-box-item">
    <changeinformation :show.sync=showflag></changeinformation>
    <div class="bigImg-div" @click="toGetImg">
      <p class="line">点击上传头像</p>
      <img class="bigImg" :src=information.picture v-if="information.picture">
    </div>
    <div class="box1"></div>
    <div class="username">{{information.username}}</div>
    <div class="box">
      <div class="information">性别：{{information.sex}}
        <img class="in" src="../assets/big.png" @click="show">
      </div>
      <div class="information">年龄：{{information.age}}
        <img src="../assets/big.png" @click="show">
      </div>
      <div class="information">学院：{{information.college}}
        <img src="../assets/big.png" @click="show">
      </div>
      <div class="information">专业班级：{{information.classes}}
        <img src="../assets/big.png" @click="show">
      </div>
      <div class="box2"></div>
    </div>
    <div class="return" @click="back()">点击返回</div>
  </div>
</template>

<script>
import axios from "axios";
import changeinformation from "@/components/changeinformation";
let inputElement = null
export default {
  name: 'informations',
  data() {
    return {
      valueUrl: '',
      showflag: false,
      information: {
        username: '',
        picture: '',
        sex: '',
        age: '',
        college: '',
        classes: ''
      }
    }
  },
  components: {
    changeinformation
  },
  methods: {
    back: function () {
      this.$router.replace("/homepage")
    },
    show: function () {
      this.showflag = true
    },
    toGetImg() {
      if (inputElement === null) {
        // 生成文件上传的控件
        inputElement = document.createElement('input')
        inputElement.setAttribute('type', 'file')
        inputElement.style.display = 'none'

        if (window.addEventListener) {
          inputElement.addEventListener('change', this.uploadFile, false)
        } else {
          inputElement.attachEvent('onchange', this.uploadFile)
        }

        document.body.appendChild(inputElement)
      }
      inputElement.click()
    },
    uploadFile(el) {
      if (el && el.target && el.target.files && el.target.files.length > 0) {
        console.log(el)
        const files = el.target.files[0]
        const isLt2M = files.size / 1024 / 1024 < 2
        const size = files.size / 1024 / 1024
        console.log(size)
        // 判断上传文件的大小
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!')
        } else if (files.type.indexOf('image') === -1) { //如果不是图片格式
          // this.$dialog.toast({ mes: '请选择图片文件' });
          this.$message.error('请选择图片文件');
        } else {
          const that = this;
          const reader = new FileReader(); // 创建读取文件对象
          reader.readAsDataURL(el.target.files[0]); // 发起异步请求，读取文件
          reader.onload = function() { // 文件读取完成后
            // 读取完成后，将结果赋值给img的src
            that.valueUrl = this.result;
            that.information.picture = this.result;
            console.log(that.information.picture);
            // 数据传到后台
            //const formData = new FormData()
            //formData.append('file', files); // 可以传到后台的数据
            axios
                .post("http://xcyzz.vipgz4.idcfengye.com/information/add",that.information)
                .then(function (response) {
                  console.log(response.data);
                })
                .catch(function (error) {
                  console.log(error)
                });
          };
        }
      }
    }

  },
  beforeDestroy() {
    if (inputElement) {
      if (window.addEventListener) {
        inputElement.removeEventListener('change', this.onGetLocalFile, false)
      } else {
        inputElement.detachEvent('onchange', this.onGetLocalFile)
      }
      document.body.removeChild(inputElement)
      inputElement = null
      console.log('========inputelement destroy')
    }
  },
  created:function () {
    var that = this
    if (this.$store.state.username == ''){
      that.$router.replace("/")
    } else {
      that.information.username = that.$store.state.username;
      console.log(that.information.username)
      axios
          .post("http://xcyzz.vipgz4.idcfengye.com/information/create",that.information.username)
          .then(function (response) {
            console.log(response.data)
            that.information = response.data
          })
          .catch(function (error) {
            console.log(error)
          })
    }
  }
}
</script>

<style>
.alert-box-item {
  background-color: #f5f7f9;
  overflow: hidden;
  bottom: 0px;
}
.username {
  position: fixed;
  font-size: 300%;
  font-family: 'Helvetica Neue', Helvetica, Arial, Sans-serif;
  left: 40%;
  top: 30px;
}
.bigImg-div {
  z-index: 10;
  position: fixed;
  width: 100px;
  height: 100px;
  border-radius: 100%;
  overflow: hidden;
  border: 1px solid #ddd;
}

.bigImg {
  z-index: 10;
  position: fixed;
  display: block;
  width: 100px;
  height: 100px;
  border-radius: 100%;
}
.box {
  margin-top: 120px;
}
.information {
  display: flex;
  justify-content: space-between;
  left: 5%;
  right: 5%;
  height: 50px;
  line-height: 50px;
  margin-top: 1%;
  font-size: 120%;
  font-family: 'Helvetica Neue', Helvetica, Arial, Sans-serif;
  background-color: white;
}
.information img {
  position: relative;
  top: 9px;
  width: 32px;
  height: 32px;
}
.box1 {
  position: fixed;
  z-index: 0;
  width: 100%;
  height: 117px;
  background-color: white;
}
.box2 {
  width: 100%;
  height: 3px;
  background-color: #f5f7f9;
}

.return {
  position: fixed;
  text-align: center;
  color: #53e3a6;
  top: 500px;
  width: 100%;

}

.line {
  position: fixed;
  top:26px;
  z-index: 1;
}
</style>