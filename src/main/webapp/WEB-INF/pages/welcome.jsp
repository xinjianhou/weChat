<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../common/taglibs.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<meta name='description' content='A simple page'>
	<script type="text/javascript" src="<%=path%>/resources/js/echarts.min.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/china.js"></script>
	<script type="text/javascript" src="<%=path%>/resources/js/world.js"></script>
</head>
<body>
	<table style="width:100%; height:100%;">
		<tr>
			<td style="height: 30%; width: 30%;">
				<div class="d-inline p-2 bg-primary text-white">近一周的关注量</div>
				
				<div  id="are-container" style="height: 400px; width: 550px;"></div>
				 
				 <script type="text/javascript">
				
				 function loadAreChart(){
					var dom = document.getElementById("are-container");
					var myChart = echarts.init(dom);
					myChart.showLoading();
					var label = [];
					var data = [];
					
					$.ajax({
						url:'${pageContext.request.contextPath}/getRecentFollow.do',
						type:'post',
						dataType:'json',
						success:function(json){
							label = json.label;
							data = json.data;
					        
							option = {
								title: {
							        text: '关注量折线块',
							        left: 'center',
							        top: 20,
							        textStyle: {
							            color: 'black'
							        }
							    },
							    toolbox: { //可视化的工具箱
					                show: true,
					                feature: {
					                    dataView: { //数据视图
					                        show: true
					                    },
					                   
		// 			                    dataZoom: { //数据缩放视图
		// 			                        show: true
		// 			                    },
					                    saveAsImage: {//保存图片
					                        show: true
					                    },
					                    magicType: {//动态类型切换
					                        type: ['bar', 'line']
					                    },
					                    restore: { //重置
					                        show: true
					                    }
					                }
					            },
					            tooltip: { //弹窗组件
					                show: true
					            },
								xAxis : {
									type : 'category',
									boundaryGap : false,
									data : label
								},
								yAxis : {
									type : 'value'
								},
								series : [ {
									name : '人数',
									data : data,
									type : 'line',
									areaStyle : {},
									label: {normal: {
							               //show: true,
							               textStyle: {
						                        color: 'green'
						                    }
							           }}
								} ]
							};
							
							if (option && typeof option === "object") {
								myChart.hideLoading();
								myChart.setOption(option, true);
							}
						},
						error: function (errorMsg) {
							myChart.showLoading({text: "加载失败。。。"});
			  	 	 	 }
					});
				 }
				</script>
				
			</td>
			<td style="height: 30%; width: 30%;">
				<div class="d-inline p-2 bg-dark text-white">关注人群的年龄/性别比重</div>
				<div  id="pie-container" style="height: 400px; width: 550px;"></div>
				<script type="text/javascript">
				function loadPieChart(type){
					var dom = document.getElementById("pie-container");
					var myChart = echarts.init(dom);
					myChart.showLoading();
					var label = [];
					var value = [];
					var title = "";
					var reqData = {"type":type};
					$.ajax({
						url:'${pageContext.request.contextPath}/getFollowerType.do',
						type:'post',
						contentType: 'application/json; charset=UTF-8',
						dataType:'json',
						data:JSON.stringify(reqData),
						success:function(json){
							title = json.result;
							label = json.label;
							value = json.value;
// 					        for(var i=0;i<label.length;i++){
// 					        		value[i] = {'value':values[i],'name':json.label[i]};
// 					        }
							option = {
		 					    backgroundColor: '#2c343c',
							
							    title: {
							        text: '人群分类饼状图',
							        left: 'center',
							        top: 20,
							        textStyle: {
							            color: '#ccc'
							        }
							    },
							    legend:{
									orient:'vertical',
									x:'left',
									 textStyle: {
					                        color: 'rgba(255, 255, 255, 0.3)'
					                    },
									data:label
								},
							    toolbox: { //可视化的工具箱
					                show: true,
					                feature: {
					                    dataView: { //数据视图
					                        show: true
					                    },
					                   
		// 			                    dataZoom: { //数据缩放视图
		// 			                        show: true
		// 			                    },
					                    saveAsImage: {//保存图片
					                        show: true
					                    },
					                    magicType : {
							                show: true, 
							                type: 'pie',
							                option: {
							                    funnel:{
							                        x:'25%',
							                        width: '50%',
							                        funnelAlign: 'left',
							                        max: 400
							                    }
							                }
							            },
					                    myTool1:{//自定义按钮 danielinbiti,这里增加，selfbuttons可以随便取名字    
					                        show : true,//是否显示    
					                        title : '年龄', //鼠标移动上去显示的文字    
					                        icon : 'path://M525.4 721.2H330.9c-9 0-18.5-7.7-18.5-18.1V311c0-9 9.3-18.1 18.5-18.1h336.6c9.3 0 18.5 9.1 18.5 18.1v232.7c0 6 8.8 12.1 15 12.1 6.2 0 15-6 15-12.1V311c0-25.6-25.3-48.9-50.1-48.9h-335c-26.2 0-50.1 23.3-50.1 48.9v389.1c0 36.3 20 51.5 50.1 51.5h197.6c6.2 0 9.3-7.5 9.3-15.1 0-6-6.2-15.3-12.4-15.3zM378.8 580.6c-6.2 0-12.3 8.6-12.3 14.6s6.2 14.6 12.3 14.6h141.4c6.2 0 12.3-5.8 12.3-13.4 0.3-9.5-6.2-15.9-12.3-15.9H378.8z m251.6-91.2c0-6-6.2-14.6-12.3-14.6H375.7c-6.2 0-12.4 8.6-12.4 14.6s6.2 14.6 12.4 14.6h240.8c6.2 0.1 13.9-8.5 13.9-14.6z m-9.2-120.5H378.8c-6.2 0-12.3 8.6-12.3 14.6s6.2 14.6 12.3 14.6h240.8c7.7 0 13.9-8.6 13.9-14.6s-6.2-14.6-12.3-14.6z m119.4 376.6L709 714.1c9.2-12 14.6-27 14.6-43.2 0-39.4-32.1-71.4-71.8-71.4-39.7 0-71.8 32-71.8 71.4s32.1 71.4 71.8 71.4c16.3 0 31.3-5.4 43.4-14.5l31.6 31.5c3.8 3.8 10 3.8 13.8 0 3.8-3.8 3.8-10 0-13.8z m-88.8-23.6c-28.3 0-51.3-22.8-51.3-51s23-51 51.3-51c28.3 0 51.3 22.8 51.3 51s-23 51-51.3 51z', //图标    
					                       onclick:function() {//点击事件,这里的option1是chart的option信息 
// 						                    	   myChart.setOption({
// 						                    		   legend:{
// 															orient:'vertical',
// 															x:'left',
// 															 textStyle: {
// 											                        color: 'rgba(255, 255, 255, 0.3)'
// 											                    },
// 															data:['访问','邮件','广告','视频','搜索']
// 														},
// 						                    	        series: [{
// 						                    	            // 根据名字对应到相应的系列
// 						                    	            name: '年龄',
// 						                    	            data: [
// 							                    	   			{value:335, name:'访问'},
// 												            {value:310, name:'邮件'},
// 							 					            {value:274, name:'广告'},
// 							 					            {value:235, name:'视频'},
// 							 					            {value:400, name:'搜索'}]
// 						                    	        	}]
// 						                    	    });
					                    	   		loadPieChart("age");
						                        } 
					                    },
					                    myTool2:{//自定义按钮 danielinbiti,这里增加，selfbuttons可以随便取名字    
					                        show : true,//是否显示    
					                        title : '性别', //鼠标移动上去显示的文字    
					                        icon : 'path://M525.4 721.2H330.9c-9 0-18.5-7.7-18.5-18.1V311c0-9 9.3-18.1 18.5-18.1h336.6c9.3 0 18.5 9.1 18.5 18.1v232.7c0 6 8.8 12.1 15 12.1 6.2 0 15-6 15-12.1V311c0-25.6-25.3-48.9-50.1-48.9h-335c-26.2 0-50.1 23.3-50.1 48.9v389.1c0 36.3 20 51.5 50.1 51.5h197.6c6.2 0 9.3-7.5 9.3-15.1 0-6-6.2-15.3-12.4-15.3zM378.8 580.6c-6.2 0-12.3 8.6-12.3 14.6s6.2 14.6 12.3 14.6h141.4c6.2 0 12.3-5.8 12.3-13.4 0.3-9.5-6.2-15.9-12.3-15.9H378.8z m251.6-91.2c0-6-6.2-14.6-12.3-14.6H375.7c-6.2 0-12.4 8.6-12.4 14.6s6.2 14.6 12.4 14.6h240.8c6.2 0.1 13.9-8.5 13.9-14.6z m-9.2-120.5H378.8c-6.2 0-12.3 8.6-12.3 14.6s6.2 14.6 12.3 14.6h240.8c7.7 0 13.9-8.6 13.9-14.6s-6.2-14.6-12.3-14.6z m119.4 376.6L709 714.1c9.2-12 14.6-27 14.6-43.2 0-39.4-32.1-71.4-71.8-71.4-39.7 0-71.8 32-71.8 71.4s32.1 71.4 71.8 71.4c16.3 0 31.3-5.4 43.4-14.5l31.6 31.5c3.8 3.8 10 3.8 13.8 0 3.8-3.8 3.8-10 0-13.8z m-88.8-23.6c-28.3 0-51.3-22.8-51.3-51s23-51 51.3-51c28.3 0 51.3 22.8 51.3 51s-23 51-51.3 51z', //图标    
					                       onclick:function() {//点击事件,这里的option1是chart的option信息 
// 						                    	   myChart.setOption({
// 						                    	        series: [{
// 						                    	            // 根据名字对应到相应的系列
// 						                    	            name: '性别',
// 						                    	            data: [
// 						                    	            			{value:335, name:'男性'},
// 												                {value:310, name:'女性'}]
// 						                    	        	}]
// 						                    	    });
					                    	   loadPieChart("sex");
						                        } 
					                    },
					                    restore: { //重置
					                        show: true
					                    }
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
							            name:title,
							            type:'pie',
							            radius : '55%',
							            center: ['50%', '50%'],
							            data:value.sort(function (a, b) { return a.value - b.value; }),
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
							                    //color: '#c23531',
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
							    ]
							};
							if (option && typeof option === "object") {
								myChart.hideLoading();
							    myChart.setOption(option, true);
							}
						}
					});
				 }
				
				</script>
			</td>
			
		</tr>
		<tr>
			<td colspan='2' >
				
				<div id="mapPieCharts" style="height: 400px; width:1100px;" ></div>
				<script type="text/javascript">
				 function FunDraw() {
			  	 	 //---地图饼状图 ---
			  	 	 var mapChart = echarts.init(document.getElementById('mapPieCharts'));
			  	 	 mapChart.showLoading();
			  	 	 
			  	 	 var seriesMapData;
			  	 	 var seriesPieData;
			  	 	 var legendData;
			  	 	 $.ajax({
			  	 	 	 type: "get",
			  	 	 	 async: false, //同步执行
			  	 	 	 url:'${pageContext.request.contextPath}/before_check.do?username=admin&password=admin123',
			  	 	 	 dataType: "json",
			  	 	 	 success: function (result) {
// 			  	 	 	 	 seriesMapData = eval('(' + result.split('_')[0] + ')');
// 			  	 	 	 	 seriesPieData = eval('(' + result.split('_')[1] + ')');
// 			  	 	 	 	 legendData = eval('(' + result.split('_')[2] + ')');
			  	 	 		 mapChart.hideLoading();
			  	 	 	 },
			  	 	 	 error: function (errorMsg) {
			  	 	 		myChart.showLoading({text: "加载失败。。。"});
			  	 	 	 }
			  	 	 });
			  	 	 mapChart.setOption({
			  	 	 	 title: {
			  	 	 	 	 text: new Date().getFullYear() + '全国各省份订阅量统计（个）',
			  	 	 	 	 subtext: '数据来自即时统计'
			  	 	 	 },
			  	 	 	 tooltip: {
			  	 	 	 	 trigger: 'item'
			  	 	 	 },
			  	 	 	 legend: {
			  	 	 	 	 x: 'center',
			  	 	 	 	 //selectedMode: true,
			  	 	 	 	 data: ['上海','江苏','浙江','山西','北京','山东']
			  	 	 	 },
			  	 	 	 dataRange: {
			  	 	 	 	 orient: 'horizontal',
			  	 	 	 	 min: 0,
			  	 	 	 	 max: 200,
			  	 	 	 	 text: [' 高', '分布数：低'],
			  	 	 	 	 splitNumber: 0, 
			  	 	 	 	 color: ['orangered', 'yellow', 'lightskyblue']
			  	 	 	 },
			  	 	 	 //animation: false,
			  	 	 	 series: [
									{
					 					name: new Date().getFullYear() + '全国各省份订阅量',
					 					type: 'map',
					 					mapType: 'china',
					 					left: '20%',
					 					//selectedMode: 'multiple',
					 					 itemStyle: {  
					                         normal: { label: { show: true } },  
					                         emphasis: { label: { show: true } }  
					                     },
					                     //center: [document.getElementById('mapPieCharts').offsetWidth -250, 225],
					 					data: [
					 	                    {name: '上海', value: 12},
					 	                    {name: '浙江', value: 13},
					 	                    {name: '北京', value: 11},
					 	                    {name: '山西', value: 123},
					 	                    {name: '山东', value: 2}
					 	                    
					 	                ]
									},
									
									{
					 					name: new Date().getFullYear() + '全国各省份订阅量',
					 					type: 'pie',
					 					roseType: 'area',
					 					tooltip: {
					 	 					trigger: 'item',
					 	 					formatter: "{a} <br />{b} : {c} ({d}%)"
					 					},
					 					center: [document.getElementById('mapPieCharts').offsetWidth - 250, 225],
					 					radius: [30, 120],
					 					data: [
					 						{name: '上海', value: 12},
					 	                    {name: '浙江', value: 13},
					 	                    {name: '北京', value: 11},
					 	                    {name: '山西', value: 123},
					 	                    {name: '山东', value: 2}
					 	                    
					 	                ]
									}
			  	 	 	 ]
			  	 	 });

			  	 }
				</script>
			</td>
		</tr>
		<tr>
		<td>&nbsp;</td></tr>
		<tr>
		<td>&nbsp;</td></tr>
		<tr></tr>
	</table>
	<script type="text/javascript">
	$(function(){
		
		loadAreChart();
		loadPieChart('age');
		FunDraw();
	});

	</script>
		 
</body>

</html>