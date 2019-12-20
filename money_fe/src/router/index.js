import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import AddBill from '@/components/bill/addBill.vue'

Vue.use(Router)

export default new Router({
    routes: [{
        path: '/',
        name: 'HelloWorld',
        component: HelloWorld,
        children: [{
            path: '/addBill',
            name: 'addBill',
            component: AddBill,
        }]
    }]
})