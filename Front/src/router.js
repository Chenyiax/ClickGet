import Vue from 'vue';
import VueRouter from "vue-router";

import login from "@/view/Login";
import homepage from "@/view/homepage";
import mytask from "@/view/mytask";
import informations from "@/view/informations";
import get from "@/view/get";
Vue.use(VueRouter)

const router = new VueRouter({
    routes:[
        {
            path: '/',
            name: login,
            component: login
        },
        {
            path: '/homepage',
            name: homepage,
            component: homepage
        },
        {
            path: '/mytask',
            name: mytask,
            component: mytask
        },
        {
            path: '/information',
            name: informations,
            component: informations
        },
        {
            path: '/get',
            name: get,
            component: get
        }
    ]
})

export default router;