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
            url : '${path }/employee/userinfoGrid',
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
                title : '部门',
                field : 'developer'
            },{
                width : '80',
                title : '职务',
                field : 'zhiwu'
            },{
                width : '40',
                title : '性别',
                field : 'sex'
            },{
                width : '80',
                title : '入职时间',
                field : 'joinTime'
            },{
                width : '80',
                title : '劳动合同',
                field : 'contract'
            }, {
                width : '80',
                title : '毕业学校',
                field : 'school'
            },{
                width : '80',
                title : '专业',
                field : 'major'
            },{
                width : '80',
                title : '毕业时间',
                field : 'levelTime'
            },{
                width : '80',
                title : '学历',
                field : 'education'
            },{
                width : '150',
                title : '身份证号',
                field : 'code'
            },{
                width : '80',
                title : '出生日期',
                field : 'birthday'
            },{
                width : '200',
                title : '户口所在地',
                field : 'registered'
            },{
                width : '80',
                title : '户口类型',
                field : 'registeredType'
            },{
                width : '40',
                title : '民族',
                field : 'nation'
            },{
                width : '200',
                title : '现居住地',
                field : 'address'
            },{
                width : '80',
                title : '手机',
                field : 'telphone'
            },{
                width : '80',
                title : '电话',
                field : 'phone'
            },{
                width : '80',
                title : '婚姻状况',
                field : 'marriage'
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
                    <th>性别:</th>
                    <td><select name="sex" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
                            <option value="0" selected="selected">男</option>
                            <option value="1" >女</option>
                        </select></td>
                    <th>入职时间:</th>
                    <td>
                    <input name="createdateStart" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />至<input  name="createdateEnd" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />
                    <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true,title:'员工基本信息'" >
        <table id="dataGrid" data-options="fit:true,border:false"></table>
    </div>
    <div id="toolbar" style="display: none;">
    </div>
</body>
</html>