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
            url : '${path }/employee/customerdjinfoGrid',
            fit : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            idField : 'id',
            pageSize : 20,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [  {
                width : '150',
                title : '客户名称',
                field : 'name'
            },{
                width : '100',
                title : '客户编号',
                field : 'developer'
            },{
                width : '280',
                title : '客户地址',
                field : 'zhiwu'
            },{
                width : '50',
                title : '年份',
                field : 'school'
            },{
                width : '50',
                title : '月份',
                field : 'sex'
            },{
                width : '100',
                title : '总金额',
                field : 'joinTime'
            }, {
                width : '50',
                title : '单量',
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
                	    title : {
                	        text: '单据分析',
                	        subtext: '单据分析'
                	    },
                	    tooltip : {
                	        trigger: 'axis'
                	    },
                	    legend: {
                	        data:['总金额']
                	    },
                	    toolbox: {
                	        show : true,
                	        feature : {
                	            mark : {show: true},
                	            dataView : {show: true, readOnly: false},
                	            magicType : {show: true, type: ['line', 'bar']},
                	            restore : {show: true},
                	            saveAsImage : {show: true}
                	        }
                	    },
                	    calculable : true,
                	    xAxis : [
                	        {
                	            type : 'category',
                	            data : ['安芙电子科技（上海）有限公司','安徽省创凯电子有限公司','艾朗特思电子（深圳）有限公司']
                	        }
                	    ],
                	    yAxis : [
                	        {
                	            type : 'value'
                	        }
                	    ],
                	    series : [
                	        {
                	            name:'总金额',
                	            type:'bar',
                	            data:[56981423, 36258410, 95841246],
                	            markPoint : {
                	                data : [
                	                    {type : 'max', name: '最大值'},
                	                    {type : 'min', name: '最小值'}
                	                ]
                	            },
                	            markLine : {
                	                data : [
                	                    {type : 'average', name: '平均值'}
                	                ]
                	            }
                	        }
                	    ]
                	};  
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
                    <th>客户名称:</th>
                    <td><input name="name" placeholder="请输入客户名称"/></td>
                    <th>查询月份:</th>
                    <td>
                    <input name="createdateStart" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />
                    <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true,title:'图表分析'" id="main" style="height:800px;border:1px solid #ccc;padding:10px;"></div>
    <div data-options="region:'west',border:true,split:false,title:'单据分析'"  style="width:800px;overflow: hidden; ">
        <table id="dataGrid" data-options="fit:true,border:false"></table>
    </div>
    <div id="toolbar" style="display: none;">
    </div>
</body>
</html>