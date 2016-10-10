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
            url : '${path }/employee/customerinfoGrid',
            fit : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            idField : 'id1',
            pageSize : 20,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [  {
                width : '150',
                title : '编号',
                field : 'contract',
                sortable : true
            },{
                width : '150',
                title : '公司全称',
                field : 'name'
            },{
                width : '150',
                title : '公司简称',
                field : 'developer'
            },{
                width : '250',
                title : '注册地址',
                field : 'zhiwu'
            },{
                width : '80',
                title : '所属行业',
                field : 'sex'
            },{
                width : '150',
                title : '成立时间',
                field : 'joinTime'
            },{
                width : '200',
                title : '送货地址',
                field : 'school'
            },{
                width : '100',
                title : '办公地产权',
                field : 'major'
            },{
                width : '100',
                title : '公司面积',
                field : 'levelTime'
            },{
                width : '80',
                title : '注册资金',
                field : 'education'
            },{
                width : '80',
                title : '员工人数',
                field : 'code'
            },{
                width : '100',
                title : '公司类型',
                field : 'birthday'
            },{
                width : '80',
                title : '管理人',
                field : 'registered'
            },{
                width : '100',
                title : '新老客户',
                field : 'registeredType'
            },{
                width : '100',
                title : '其他产业',
                field : 'nation'
            }] ],
            toolbar : '#toolbar'
        });
        
        dataGrid1 = $('#dataGrid1').datagrid({
            url : '${path }/employee/customertgGrid',
            fit : true,
            striped : true,
            idField : 'id2',
            pageSize : 20,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ {
                width : '150',
                title : '合同编号',
                field : 'name'
            },{
                width : '150',
                title : '结算客户',
                field : 'developer'
            },{
                width : '100',
                title : '经营单位',
                field : 'zhiwu'
            },{
                width : '80',
                title : '运作地',
                field : 'sex'
            },{
                width : '100',
                title : '合同性质',
                field : 'joinTime'
            },{
                width : '100',
                title : '代理/自营',
                field : 'contract'
            },{
                width : '80',
                title : '合同币种',
                field : 'school'
            },{
                width : '150',
                title : '收货单位',
                field : 'major'
            },{
                width : '100',
                title : '合同日期',
                field : 'levelTime'
            },{
                width : '150',
                title : '买方',
                field : 'education'
            },{
                width : '150',
                title : '卖方',
                field : 'code'
            }] ]
        });
        
        dataGrid2 = $('#dataGrid2').datagrid({
            url : '${path }/employee/customerwlGrid',
            fit : true,
            striped : true,
            idField : 'id3',
            pageSize : 20,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [ {
                width : '150',
                title : '仓库名称',
                field : 'name'
            },{
                width : '150',
                title : '现在状态',
                field : 'developer'
            },{
                width : '100',
                title : '货物类型',
                field : 'zhiwu'
            },{
                width : '100',
                title : '入仓时间',
                field : 'sex'
            },{
                width : '500',
                title : '备注',
                field : 'code'
            }] ]
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
                    <th>公司名称:</th>
                    <td><input name="name" placeholder="请输入公司姓名"/></td>
                    <th>新老客户:</th>
                    <td><select name="sex" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                            <option value="0" selected="selected">新客户</option>
                            <option value="1" >老客户</option>
                        </select><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a></td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true">
    	<div data-options="region:'north',border:true,split:false,title:'客户通关信息'" style="height:400px;overflow: hidden; ">
    		<table id="dataGrid1" data-options="fit:true,border:false,title:'客户通关信息'"></table>
    	</div>
    	<div data-options="region:'center',border:true" style="height:800px;overflow: hidden; ">
    		<table id="dataGrid2" data-options="fit:true,border:false,title:'客户仓库物流信息'"></table>
    	</div>
    </div>
    <div data-options="region:'west',border:true,split:false,title:'客户基本信息'" style="width:800px;overflow: hidden; ">
        <table id="dataGrid" data-options="fit:true,border:false"></table>
    </div>
    <div id="toolbar" style="display: none;">
    </div>
</body>
</html>