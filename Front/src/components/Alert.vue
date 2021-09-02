<template>
  <transition name="confirm-fade">
    <div v-if="show" class="confirm">
      <div class="confirm-content-wrap">
        <h3 class="confirm-title">{{ titleText }}</h3>
        <p class="confirm-content">{{ content }}</p>
        <div class="confirm-btn">
            <p class="btn-text" @click="closeshow()">{{ confirmText }}</p>
        </div>
      </div>
    </div>
  </transition>
</template>

<script type="text/ecmascript-6">
export default {
  data () {
    return {
      titleText: '操作提示',
      confirmText: '确认',
    }
  },
  props: ['show','content'],
  methods: {
    closeshow () {
      this.$emit("update:show",false);
    }
  }
}
</script>

<style scoped>
.confirm {
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
  top: 28%;
  left: 0;
  right: 0;
  width: 280px;
  margin: 0 auto;
  background-color: #fff;
  border-radius: 5px;
  z-index: 999;
  user-select: none;
}
.confirm-title {
  padding-top: 20px;
  text-align: center;
  font-size: 20px;
  font-weight: 500;
  color: #50a3a2;
}
.confirm-content {
  padding: 0 15px;
  padding-top: 20px;
  margin-bottom: 32px;
  text-align: center;
  font-size: 16px;
  color: #50a3a2;
  line-height: 1.5;
}


.confirm-btn {
  text-align: center;
  font-size: 16px;
  margin: 14px 0;
  padding: 6px 0;
  border-top: 1px solid #eee;
  color: #53e3a6;
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