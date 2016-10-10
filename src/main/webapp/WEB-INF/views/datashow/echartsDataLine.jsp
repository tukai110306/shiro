<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
require.config({  
    paths:{   
        echarts:'../static/echart2' 
    }  
});

//按需加载  
require(  
    [  
		'echarts',  
		'echarts/chart/bar',  
		'echarts/chart/line',  
		'echarts/chart/map',
		'echarts/chart/pie'
    ],  
    function (ec) {  
        var chart = document.getElementById('main');  
        var echart = ec.init(chart);  
          
        echart.showLoading({  
            text: '正在努力加载中...'  
        });  
          
        var categories = [];  
        var values = [];
      
          
        // 同步执行  
        $.ajaxSettings.async = false;  
          
        var url="/shiro/echarts/showLineData";
		var args={"time":new Date()};
		$.getJSON(url,args,function(data){
            categories = data.categories;  
            values = data.values;  
        
           
        });  
          
        var option = {  
            tooltip: {  
                show: true  
            },  
            legend: {  
                data: ['阅读','报名','转发']  
            },  
            xAxis: [  
                {  
                    type: 'category',  
                    data: categories  
                }  
            ],  
            yAxis: [  
                {  
                    type: 'value'  
                }  
            ],  
            series: [  
                {  
                    'name': '阅读',  
                    'type': 'bar',  
                    'data': values
                }
            ]  
        };  
          
        echart.setOption(option);  
        echart.hideLoading();  
    }  
);
</script>
</head>
<body>
<div id="main" style="height:500px;border:1px solid #ccc;padding:10px;"></div> 
</body>
</html>