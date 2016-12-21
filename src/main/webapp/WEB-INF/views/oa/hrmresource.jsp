<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>流程查询</title>
    <script type="text/javascript">

    var dataGrid;
    var organizationTree;

    $(function() {

        dataGrid = $('#dataGrid').datagrid({
            url : '${path }/oaflow/hrmresourceGrid',
            fit : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            idField : 'id',
            onLoadSuccess:function(data){
				$(this).datagrid('doCellTip',{'max-width':'300px','delay':500});
			},
            pageSize : 20,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [  {
                width : '80',
                title : '系统类型',
                field : 'xttype'
            },{
                width : '80',
                title : '申请人',
                field : 'sqname'
            },{
                width : '80',
                title : '流程提交日期',
                field : 'createdate'
            },{
                width : '300',
                title : '申请原因',
                field : 'createreason'
            },{
                width : '400',
                title : '需求说明',
                field : 'remark'
            }, {
                width : '80',
                title : '预计开始日期',
                field : 'yjbegintm'
            },{
                width : '80',
                title : '预计完成日期',
                field : 'yjendtm'
            },{
                width : '300',
                title : '实现功能',
                field : 'realize'
            },{
                width : '80',
                title : '负责工程师',
                field : 'byuser'
            },{
                width : '80',
                title : '实际开始日期',
                field : 'sjbegintm'
            },{
                width : '80',
                title : '实际完成日期',
                field : 'sjendtm'
            },{
                width : '80',
                title : '是否通过验收',
                field : 'checkstate'
            }] ],
            toolbar : '#toolbar'
        });
        
        $('#userId').combotree({
            url: '${path }/oaflow/needUserList',
            valueField: 'id',
            textField: 'name',
            panelHeight: 'auto'
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
                    <th>负责工程师:</th>
                    <td><select id="userId" name="userId" style="width: 140px; height: 29px;"></select></td>
                    <th>流程提交日期:</th>
                    <td>
                    <input name="createdateStart" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly" />至<input  name="createdateEnd" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly" />
                    <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true,title:'流程基本信息'" >
        <table id="dataGrid" data-options="fit:true,border:false"></table>
    </div>
    <div id="toolbar" style="display: none;">
    </div>
</body>
</html>