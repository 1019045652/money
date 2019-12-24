<template>
  <div>
    <!-- 新增模块 -->
    <a-button size="large" type="primary" @click="showModal">添加账单</a-button>
    <a-modal v-model="visible" title="添加账单" onOk="handleOk">
      <div>
        <!--表单（金额） -->
        <label>
          <span style="color:red;">*</span>金额：
        </label>
        <a-input v-model="money" placeholder="请输入金额数量" style="width:200px;"/>
        <br>
        <br>
        <!--表单（类型） -->
        <label>
          <span style="color:red;">*</span>类型：
        </label>
        <a-select
          v-model="billType"
          defaultValue="lucy"
          style="width: 120px"
          @change="handleChange"
        >
          <a-select-option value="jack">Jack</a-select-option>
          <a-select-option value="lucy">Lucy</a-select-option>
        </a-select>
        <br>
        <br>
        <!--表单（时间） -->
        <span>
          <span style="color:red;">*</span>日期：
        </span>
        <a-date-picker placeholder="选择日期" v-model="createTime" @change="onChange"/>
        <br>
        <br>
        <!--表单（备注） -->
        <span>
          <span style="color:red;">*</span>备注：
        </span>
        <a-textarea v-model="desc" placeholder="输入备注" :rows="4" style="width:300px;"/>
      </div>
      <template slot="footer">
        <a-button key="back" @click="handleCancel">取消</a-button>
        <a-button key="submit" type="primary" :loading="loading" @click="handleOk">提交</a-button>
      </template>
    </a-modal>
    <!-- 数据表格模块 -->
    <a-divider>数据表格</a-divider>
    <a-table :columns="columns" :dataSource="data">
     <template slot="createTime" slot-scope="text,record,index">
       {{record.createTime|dateFormat}}
      </template>
      <a slot="action" slot-scope="text" href="javascript:;">Delete</a>
      <p slot="expandedRowRender" slot-scope="record" style="margin: 0">备注：{{record.note}}</p>
    </a-table>
  </div>
</template>
<script>
import format from '@/utils/format.js'
const columns = [
  { title: "userId", dataIndex: "userId", key: "userId" },
  { title: "类型", dataIndex: "typeName", key: "typeName" },
  { title: "金额", dataIndex: "money", key: "money" },
  { title: "时间", dataIndex: "createTime", key: "createTime",scopedSlots: { customRender: 'createTime' },},
  {
    title: "Action",
    dataIndex: "",
    key: "x",
    scopedSlots: { customRender: "action" }
  }
];

export default {
  data() {
    return {
      data: [],
      columns,
      loading: false,
      visible: false,
      createTime: "",
      money: "",
      billType: "",
      desc: "",
      flag: 0
    };
  },
  filters: {
    dateFormat(date) {
      return format.formatDate(date, "yyyy-MM-dd hh:mm:ss");
    }
  },
  watch: {
    flag: "getAllBill"
  },
  methods: {
    // 显示对话框
    showModal() {
      this.visible = true;
    },
    // 提交按钮
    handleOk(e) {
      this.loading = true;
      if (this.validate() === false) {
        this.loading = false;
        return;
      }
      var param = {
        userId: 1,
        money: this.money,
        createTime: this.createTime,
        billType: this.billType,
        desc: this.desc,
        state:0
      };
      axios.post("http://localhost:8081/bill/addBill", param).then(res => {
        if (res.data.code === 200) {
          this.visible = false;
          this.loading = false;
          this.$notification.success({
            message: res.data.msg
          });
          this.flag++;
        }
      });
    },
    //校验表单数据
    validate() {
      if (this.money === "") {
        this.$message.error("请输入金额", 1);
        return false;
      }
      if (this.billType === "") {
        this.$message.error("请选择类型", 1);
        return false;
      }
      if (this.createTime === "") {
        this.$message.error("请选择时间", 1);
        return false;
      }
      if (this.desc === "") {
        this.$message.error("请输入备注", 1);
        return false;
      }
    },
    // 取消按钮
    handleCancel(e) {
      this.visible = false;
    },
    getAllBill() {
      axios.get("http://localhost:8081/bill/getAllBill").then(res => {
        this.data = res.data.data;
      });
    }
  },
  mounted() {
    this.getAllBill();
  }
};
</script>