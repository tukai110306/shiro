<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工基本信息</title>
    <script type="text/javascript">

    var dataGrid;
    var organizationTree;

    $(function() {

        dataGrid = $('#dataGrid').datagrid({
            url : '${path }/employee/usercgGrid',
            fit : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            idField : 'id',
            pageSize : 20,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [  {
                width : '80',
                title : '采购部门',
                field : 'developer',
                sortable : true
            },{
                width : '80',
                title : '采购人',
                field : 'name'
            },{
                width : '80',
                title : '品类',
                field : 'address'
            },{
                width : '150',
                title : '小类',
                field : 'birthday'
            },{
                width : '150',
                title : '金额',
                field : 'code'
            },{
                width : '150',
                title : '采购时间',
                field : 'joinTime'
            }, {
                width : '150',
                title : '备注',
                field : 'contract'
            }] ],
            toolbar : '#toolbar'
        });
    });
    
    function searchFun() {
        dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
    }
    function cleanFun() {
        $('#searchForm input').val('');
        dataGrid.datagrid('load', {});
    }
    
    require.config({  
        paths:{   
            echarts:'../static/echart2' 
        }  
    });

    require(  
            [  
            'echarts',  
            'echarts/chart/bar',  
            'echarts/chart/line',  
            'echarts/chart/map',
            'echarts/chart/pie'
            ],  
            function(ec) {  
                //--- 折柱 ---  
                var myChart = ec.init(document.getElementById('main'));  
      
                // 过渡---------------------  
               /*  myChart.showLoading({  
                    text: '正在努力的读取数据中...',    //loading话术  
                });  */
                option = {
                	    tooltip : {
                	        trigger: 'item',
                	        formatter: "{a} <br/>{b} : {c} ({d}%)"
                	    },
                	    legend: {
                	        orient : 'vertical',
                	        x : 'left',
                	        data:['电脑周边','办公耗材','办公文具','信息部','市场部','行政部','财务部','关务部']
                	    },
                	    toolbox: {
                	        show : true,
                	        feature : {
                	            mark : {show: true},
                	            dataView : {show: true, readOnly: false},
                	            magicType : {
                	                show: true, 
                	                type: ['pie', 'funnel']
                	            },
                	            restore : {show: true},
                	            saveAsImage : {show: true}
                	        }
                	    },
                	    calculable : false,
                	    series : [
                	        {
                	            name:'采购种类',
                	            type:'pie',
                	            selectedMode: 'single',
                	            radius : [0, 70],
                	            
                	            // for funnel
                	            x: '20%',
                	            width: '40%',
                	            funnelAlign: 'right',
                	            max: 1548,
                	            
                	            itemStyle : {
                	                normal : {
                	                    label : {
                	                        position : 'inner'
                	                    },
                	                    labelLine : {
                	                        show : false
                	                    }
                	                }
                	            },
                	            data:[
                	                {value:25964, name:'电脑周边'},
                	                {value:46487, name:'办公耗材'},
                	                {value:2140, name:'办公文具', selected:true}
                	            ]
                	        },
                	        {
                	            name:'采购部门',
                	            type:'pie',
                	            radius : [100, 140],
                	            
                	            // for funnel
                	            x: '60%',
                	            width: '35%',
                	            funnelAlign: 'left',
                	            max: 1048,
                	            
                	            data:[
                	                {value:25964, name:'信息部'},
                	                {value:46487, name:'市场部'},
                	                {value:1120, name:'行政部'},
                	                {value:590, name:'财务部'},
                	                {value:430, name:'关务部'}
                	            ]
                	        }
                	    ]
                	};
                	var ecConfig = require('echarts/config');
                	myChart.on(ecConfig.EVENT.PIE_SELECTED, function (param){
                	    var selected = param.selected;
                	    var serie;
                	    var str = '当前选择： ';
                	    for (var idx in selected) {
                	        serie = option.series[idx];
                	        for (var i = 0, l = serie.data.length; i < l; i++) {
                	            if (selected[idx][i]) {
                	                str += '【系列' + idx + '】' + serie.name + ' : ' + 
                	                       '【数据' + i + '】' + serie.data[i].name + ' ';
                	            }
                	        }
                	    }
                	    document.getElementById('wrong-message').innerHTML = str;
                	}); 
                	myChart.setOption(option);  
                	  
                	  
                	}  
                	);
    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchForm">
            <table>
                <tr>
                    <th>部门:</th>
                    <td><select name="sex" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                            <option value="0" selected="selected">销售部</option>
                            <option value="1" >市场部</option>
                            <option value="2" >开发部</option>
                        </select></td>
                    <th>品类:</th>
                    <td><select name="sex" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                            <option value="0" selected="selected">电脑周边</option>
                            <option value="1" >办公纸张</option>
                            <option value="2" >办公设备</option>
                        </select></td>
                    <th>查询时间:</th>
                    <td>
                    <input name="createdateStart" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />至<input  name="createdateEnd" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />
                    <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true,title:'图表分析'" id="main" style="height:800px;border:1px solid #ccc;padding:10px;"></div>
    <div data-options="region:'west',border:true,split:false,title:'数据分析'"  style="width:800px;overflow: hidden; ">
        <table id="dataGrid" data-options="fit:true,border:false"></table>
    </div>
    <div id="toolbar" style="display: none;">
    </div>
</body>
</html>