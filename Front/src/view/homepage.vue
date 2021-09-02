<template>
  <div class="drawer">
    <addform :show.sync=showflag></addform>
    <showform :show.sync=showtest :username.sync=this.tasks[this.i].user1 :title.sync=this.tasks[this.i].title :content.sync=this.tasks[this.i].content :repay.sync=this.tasks[this.i].repay></showform>
    <header id="header" class="header">
      <div class="menu" @click="open"></div>
      <div class="search">
        <form>
          <div class="search-text">
            <input type="text" v-model="txt" placeholder="搜索委托" />
          </div>
          <button type="submit" @click="search" />
        </form>
      </div>
    </header>
  <div v-for="(task,i) in tasks" :key="task.id">
    <div class="box" @click="showform(i)">
      <p class="title">{{task.title}}</p>
      <p class="content">{{task.content}}</p>
      <p class="temp">浏览次数：{{task.temp}} 发布日期:{{task.date}}</p>
    </div>
  </div>
    <div class="photobox" >
      <img class="photo" src="../assets/add.jpg" @click="addform">
    </div>

    <setbox :showflag.sync="show"></setbox>

  </div>
</template>

<script>
import addform from "@/components/addform";
import setbox from "@/components/setbox";
import axios from "axios";
import Showform from "@/components/showform";
export default {
  name: "homepage",
  components: {
    Showform,
    addform,
    setbox,
  },
  data() {
    return {
      name: '',
      txt: '',
      show: false,
      showflag: false,
      showtest: false,
      tasks:[{user1: '',title: '',content: '',repay: ''}],
      i: 0,
    }
  },
  methods: {
    open() {
      this.show = true
    },
    addform() {
      this.showflag = true
    },
    showform(i) {
      this.i = i
      this.showtest = true
    },
    search() {
      var that = this;
      var task = {title: this.txt}
      axios
          .post("http://xcyzz.vipgz4.idcfengye.com/homepage/searchtask", task)
          .then(function (response) {
            console.log(response.data.length)
            that.tasks = response.data;
            if(response.data.length == 0) {
              that.tasks[0] = {user1: '无',title: '找不到符合的条件',content: '无',repay: '0'}
            }

          })
          .catch(function (error) {
            console.log(error)
          })
    }
  },

  created:function () {
    var that = this;
    if(this.$store.state.username == '') {
      that.$router.replace("/")
    } else {
      axios
          .post("http://xcyzz.vipgz4.idcfengye.com/homepage/showtask")
          .then(function (response) {
            console.log(response.data);
            that.tasks = response.data;
          })
          .catch(function (error) {
            console.log(error)
          });
    }


  }
}
</script>

<style scoped>
.drawer {
  z-index: 0;
  height: auto;
  width: 100%;
  display: flex;
  flex-direction: column;

}
.menu{
  top:27px;
  left: 10px;
  position: absolute;
  padding: 5px 0;
  width: 25px;
  height: 3px;
  background: #02D97C;
  background-clip: content-box;
  border-top: 3px solid #02D97C;
  border-bottom: 3px solid #02D97C;
}
.box {
  margin-top: 5px;
  box-shadow:2px 2px 8px #909090;
  background-color: rgba(255,255,255,0.2);
  height: auto;
  padding: 10px 0px 10px;
}
.title {
  margin: 0px 10px;
  font-weight: bold;
  font-size: 20px;
  font-family: 'Helvetica Neue',Helvetica,Arial,Sans-serif;
}
.content {
  margin: 0px 10px;
  font-size: 15px;
  font-family: 'Helvetica Neue',Helvetica,Arial,Sans-serif;
}
.temp {
  margin: 0px 10px;
  font-size: 10px;
  color: grey;
  bottom: 0px;
}
.photobox {
  display: flex;
  justify-content: center;
  margin-top: 5px;
  box-shadow:2px 2px 8px #909090;
  background-color: rgba(255,255,255,1);
  height: auto;
}
.photo {
  height: 80px;
  width: 80px;
}
.header {
  background-color: #ffffff;
}
.search {
  padding: .36rem 2.4rem;
}
.search form {
  position: relative;
  background-color: #e4e4e4;
  border-radius: 50px;
  overflow: hidden;
}
.search form button[type="submit"] {
  position: absolute;
  top: 0px;
  right: 0px;
  width: 50px;
  height: 50px;
  border: none;
  background: url("../assets/search-btn.png")
  no-repeat center; background-size: 50%;
}
.search-text input[type="text"] {
  display: block;
  width: 100%;
  height: 50px;
  padding-right: 30px;
  padding-left: 30px;
  border: none;
  background: none;
  font-size: large;
}
.search-text input[type="text"]:focus {
  color: #53e3a6;
  outline: none;
}

</style>