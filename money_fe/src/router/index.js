export default new VueRouter({
    routes: [{
        path: '/',
        name: 'HelloWorld',
        component: resolve => require(['@/components/main'], resolve),
        children: [{
            path: '/addBill',
            name: 'addBill',
            component: resolve => require(['@/components/bill/addBill.vue'], resolve)
        }]
    }]
})