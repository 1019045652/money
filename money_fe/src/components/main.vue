<template>
  <a-layout id="components-layout-demo-top-side-2">
    <a-layout-header class="header" style="padding-left:20px;">
      <span style="float:left;color:white;">测试logo</span>
      <!-- <a-menu theme="dark" mode="horizontal" :style="{ lineHeight: '64px' }">
        <a-menu-item key="1" @click="addBill()" style="margin-left:126px;">第一个菜单</a-menu-item>
        <a-menu-item key="2">nav 2</a-menu-item>
        <a-menu-item key="3">nav 3</a-menu-item>
      </a-menu> -->
    </a-layout-header>
    <a-layout>
      <a-layout-sider width="200" style="background: #fff">
        <a-menu
          mode="inline"
          :style="{ height: '100%', borderRight: 0 }"
          @openChange="onOpenChange"
          :openKeys="openKeys"
        >
          <a-sub-menu key="sub1">
            <span slot="title">
              <a-icon type="safety-certificate" theme="filled"/>账户设置
            </span>
            <a-menu-item key="1">资产信息</a-menu-item>
            <a-menu-item key="2">二二二</a-menu-item>
            <a-menu-item key="3">菜单三</a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub2">
            <span slot="title">
              <a-icon type="pie-chart" theme="filled"/>账单信息
            </span>
            <a-menu-item key="5" @click="addBill()">账单列表</a-menu-item>
            <a-menu-item key="6">账单分类</a-menu-item>
            <a-menu-item key="7">资产规划</a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub3">
            <span slot="title">
              <a-icon type="pie-chart" theme="filled"/>报表信息
            </span>
            <a-menu-item key="9" @click="toPayChart()">消费报表</a-menu-item>
            <a-menu-item key="10">行程报表</a-menu-item>
            <a-menu-item key="11">保留菜单</a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub4">
            <span slot="title">
              <a-icon type="schedule" theme="filled"/>日程信息
            </span>
            <a-menu-item key="13">系统设置</a-menu-item>
            <a-menu-item key="14">参数设置</a-menu-item>
            <a-menu-item key="15">数据设置</a-menu-item>
          </a-sub-menu>
          <a-sub-menu key="sub5">
            <span slot="title">
              <a-icon type="setting" theme="filled"/>系统设置
            </span>
            <a-menu-item key="17">参数设置</a-menu-item>
            <a-menu-item key="18">界面设置</a-menu-item>
            <a-menu-item key="19">保留菜单</a-menu-item>
          </a-sub-menu>
        </a-menu>
      </a-layout-sider>
      <a-layout style="padding: 0 24px 24px">
        <a-breadcrumb style="margin: 16px 0">
          <a-breadcrumb-item>Home</a-breadcrumb-item>
          <a-breadcrumb-item>List</a-breadcrumb-item>
          <a-breadcrumb-item>App</a-breadcrumb-item>
        </a-breadcrumb>
        <a-layout-content
          :style="{ background: '#fff', padding: '24px', margin: 0, overflow: 'auto' }"
        >
          <router-view></router-view>
        </a-layout-content>
      </a-layout>
    </a-layout>
  </a-layout>
</template>
<script>
import { Layout, Breadcrumb, Icon, Menu } from "ant-design-vue";
export default {
  data() {
    return {
      collapsed: false,
      rootSubmenuKeys: ["sub1", "sub2", "sub3", "sub4","sub5"],
      openKeys: []
    };
  },
  components: {
    "a-layout": Layout,
    "a-layout-sider": Layout.Sider,
    "a-layout-header": Layout.Header,
    "a-layout-content": Layout.Content,
    "a-menu": Menu,
    "a-sub-menu": Menu.SubMenu,
    "a-menu-item": Menu.Item,
    "a-breadcrumb": Breadcrumb,
    "a-breadcrumb-item": Breadcrumb.Item,
    "a-icon": Icon
  },
  methods: {
    addBill() {
      this.$router.push("/addBill");
    },
    toPayChart() {
      this.$router.push("/payChart");
    },
    onOpenChange(openKeys) {
      const latestOpenKey = openKeys.find(
        key => this.openKeys.indexOf(key) === -1
      );
      if (this.rootSubmenuKeys.indexOf(latestOpenKey) === -1) {
        this.openKeys = openKeys;
      } else {
        this.openKeys = latestOpenKey ? [latestOpenKey] : [];
      }
    }
  }
};
</script>

<style>
#components-layout-demo-top-side-2 .logo {
  width: 120px;
  background: rgba(255, 255, 255, 0.2);
  margin: 16px 28px 16px 0;
  float: left;
}

#components-layout-demo-top-side-2 {
  height: 100vh;
}
</style>