<%@page contentType="text/html; UTF-8" isELIgnored="false" pageEncoding="UTF-8" language="java" %>



<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 1200px;height:500px;"></div>
<script type="text/javascript">
    //先获取dom对象
    var myChart  =  echarts.init(document.getElementById("main"));
    //自定义两个数组
    var  names=[];
    var nums=[];


    //异步加载    url
    $.get("${pageContext.request.contextPath}/manager/queryClassifyCount").done(function(data){
        //遍历后台的json集合


        for( var i  in data){
            names.push(data[i].name);
            nums.push(data[i].value);
        }

        //
        myChart.setOption({
           /* title:{
                text:'鸡汤分类统计'
            },
            tooltip:{},
            legend:{
                data:["数量"]
            },
            xAxis:{
                data:names
            },
            yAxis:{},
            series:[{
                name:"数量",
                type:"bar",
                data:nums


            }]*/
           /* backgroundColor: '#2c343c',

             title: {
             text: 'Customized Pie',
             left: 'center',
             top: 20,
             textStyle: {
             color: '#ccc'
             }
             },

             tooltip : {
             trigger: 'item',
             formatter: "{a} <br/>{b} : {c} ({d}%)"
             },

             visualMap: {
             show: false,
             min: 80,
             max: 600,
             inRange: {
             colorLightness: [0, 1]
             }
             },
             series : [
             {
             name:'鸡汤分类统计',
             type:'pie',
             radius : '55%',
             center: ['50%', '50%'],

             data:data.sort(function (a, b) { return a.value - b.value; }),
             roseType: 'radius',
             label: {
             normal: {
             textStyle: {
             color: 'rgba(255, 255, 255, 0.3)'
             }
             }
             },
             labelLine: {
             normal: {
             lineStyle: {
             color: 'rgba(255, 255, 255, 0.3)'
             },
             smooth: 0.2,
             length: 10,
             length2: 20
             }
             },
             itemStyle: {
             normal: {
             color: 'red',
             shadowBlur: 200,
             shadowColor: 'rgba(0, 0, 0, 0.5)'
             }
             },

             animationType: 'scale',
             animationEasing: 'elasticOut',
             animationDelay: function (idx) {
             return Math.random() * 200;
             }
             }
             ]*/
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b}: {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                x: 'left',
                data:names
            },
            series: [
                {
                    name:'鸡汤分类统计',
                    type:'pie',
                    radius: ['50%', '70%'],
                    avoidLabelOverlap: false,
                    label: {
                        normal: {
                            show: false,
                            position: 'center'
                        },
                        emphasis: {
                            show: true,
                            textStyle: {
                                fontSize: '30',
                                fontWeight: 'bold'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    data:data
                }
            ]

        });


    });


</script>