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
            url : '${path }/employee/userkqGrid',
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
                title : '姓名',
                field : 'name',
                sortable : true
            },{
                width : '80',
                title : '考勤号码',
                field : 'code'
            },{
                width : '80',
                title : '班次时段',
                field : 'address'
            },{
                width : '80',
                title : '剩余调休假',
                field : 'birthday'
            },{
                width : '80',
                title : '剩余年假',
                field : 'contract'
            },{
                width : '80',
                title : '加班',
                field : 'developer'
            }, {
                width : '80',
                title : '迟到',
                field : 'education'
            },{
                width : '80',
                title : '早退',
                field : 'joinTime'
            },{
                width : '80',
                title : '病假',
                field : 'levelTime'
            },{
                width : '80',
                title : '事假',
                field : 'major'
            },{
                width : '150',
                title : '当月调休',
                field : 'marriage'
            },{
                width : '80',
                title : '出勤天数',
                field : 'nation'
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
    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 30px; overflow: hidden;background-color: #fff">
        <form id="searchForm">
            <table>
                <tr>
                    <th>姓名:</th>
                    <td><input name="name" placeholder="请输入用户姓名"/></td>
                    <th>查询月份:</th>
                    <td>
                    <input name="createdateStart" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />
                    <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true,title:'员工考勤'" >
        <table id="dataGrid" data-options="fit:true,border:false"></table>
    </div>
    <div id="toolbar" style="display: none;">
    </div>
</body>
</html>