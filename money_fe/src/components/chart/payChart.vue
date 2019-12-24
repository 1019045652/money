<template>
  <div>
    <!-- 统计数据 -->
    <a-card :bordered="false">
      <a-card-grid class="card-money-first">
        <div style="float:left;width:50%;">
          <a-icon type="property-safety" theme="twoTone" style="font-size:50px;color:blue;"/>
        </div>
        <div style="float:left;width:40%;text-align:right;">
          <a-statistic title="累计消费" :value="1128" style=""></a-statistic>
        </div>
      </a-card-grid>
      <a-card-grid class="card-money">
        <div style="float:left;width:50%;">
          <a-icon
            type="taobao-circle"
            theme="filled"
            style="font-size:50px;color:rgb(255, 102, 102);"
          />
        </div>
        <div style="float:left;width:40%;text-align:right;">
          <a-statistic title="购物消费" :value="1128" style=""></a-statistic>
        </div>
      </a-card-grid>
      <a-card-grid class="card-money">
        <div style="float:left;width:50%;">
          <a-icon type="shop" theme="filled" style="font-size:50px;color:rgb(113, 189, 142);"/>
        </div>
        <div style="float:left;width:40%;text-align:right;">
          <a-statistic title="饮食消费" :value="1128" style=""></a-statistic>
        </div>
      </a-card-grid>
      <a-card-grid class="card-money">
        <div style="float:left;width:50%;">
          <a-icon
            type="customer-service"
            theme="filled"
            style="font-size:50px;color:rgb(226, 219, 117);"
          />
        </div>
        <div style="float:left;width:40%;text-align:right;">
          <a-statistic title="娱乐消费" :value="1128" style=""></a-statistic>
        </div>
      </a-card-grid>
    </a-card>
    <br>
    <br>
    <!-- 数据统计图 -->
    <a-divider>统计数据图</a-divider>
    <div id="moneyChart" style="width:100%;height:400px;margin:0;"></div>
  </div>
</template>
<script>
import { Card } from "ant-design-vue";
import format from "@/utils/format.js";
export default {
  data() {
    return {
      option: {
        title: {},
        tooltip: {
          trigger: "axis"
        },
        legend: {
          data: ["饮食消费", "娱乐消费", "购物消费"]
        },
        grid: {
          left: "3%",
          right: "4%",
          bottom: "3%",
          containLabel: true
        },
        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        xAxis: {
          type: "category",
          boundaryGap: false,
          data: []
        },
        yAxis: {
          type: "value"
        },
        series: []
      }
    };
  },
  components: {
    "a-card": Card,
    "a-card-grid": Card.Grid
  },
  mounted() {
    this.setChart();
  },
  methods: {
    setChart() {
      var _this = this;
      setTimeout(function() {
        // 基于准备好的dom，初始化echarts实例
        let moneyChart = echarts.init(document.getElementById("moneyChart"));

        //加载横坐标为前七天的数据
        var xDate = format.getSevenDay();
        xDate.forEach(a => {
          _this.option.xAxis.data.push(a);
        });
        //从服务端获取数据
        axios
          .get("http://localhost:8081/bill/getBillChartForSeven")
          .then(res => {
            var list = res.data.data;
            var foodList = [];
            var playList = [];
            var shopList = [];
            var j= 0;
            //遍历横坐标
            xDate.forEach(a => {
              j++;
              var i = 0;
              //遍历纵坐标
              list.forEach(b => {
                i++;
                if (a === b.time) {
                  if (b.typeName === "饮食") {
                    foodList.push(b.money);
                  } else if (b.typeName === "娱乐") {
                    playList.push(b.money);
                  } else if (b.typeName === "购物") {
                    shopList.push(b.money);
                  }
                } else if (i == list.length) {
                    if(foodList.length<j){
                      foodList.push(0);
                    }
                    if(playList.length<j){
                      playList.push(0);
                    }
                    if(shopList.length<j){
                      shopList.push(0);
                    }
                }
              });
            });
          //填充展示数据
            _this.option.series.push(
          {
            name: "饮食消费",
            type: "line",
            stack: "总量",
            data: foodList
          },
          {
            name: "娱乐消费",
            type: "line",
            stack: "总量",
            data: playList
          },
          {
            name: "购物消费",
            type: "line",
            stack: "总量",
            data: shopList
          }
        );
        moneyChart.setOption(_this.option);
          });
      }, 10);
      //设置echarts响应页面显示
      window.onresize = function() {
        echarts.init(document.getElementById("moneyChart")).resize();
      };
    }
  }
};
</script>
<style>
.card-money {
  width: 22% !important;
  height: 100px !important;
  margin-left: 4% !important;
  padding: 10px !important;
  padding-top: 15px !important;
}
.card-money-first {
  width: 22% !important;
  height: 100px !important;
  padding: 10px !important;
  padding-top: 15px !important;
}
.example {
  text-align: center;
  background: rgba(0, 0, 0, 0.05);
  border-radius: 4px;
  margin-bottom: 20px;
  padding: 30px 50px;
  margin: 20px 0;
}
</style>

