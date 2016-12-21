<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>交办任务</title>
    <script type="text/javascript">

    var dataGrid;
    var organizationTree;

    $(function() {

        dataGrid = $('#dataGrid').datagrid({
            url : '${path }/oaflow/assigntaskGrid',
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
                title : '申请人',
                field : 'lastname'
            },{
                width : '200',
                title : '流程编号',
                field : 'liucbh'
            },{
                width : '80',
                title : '申请日期',
                field : 'shenqrq'
            },{
                width : '100',
                title : '是否申请变更',
                field : 'shenqingbiangeng'
            },{
                width : '80',
                title : '是否延期',
                field : 'yanqigouxuan'
            },{
                width : '200',
                title : '变更说明',
                field : 'biangengshuom'
            },{
                width : '200',
                title : '来源',
                field : 'laiy'
            },{
                width : '300',
                title : '事项描述',
                field : 'shixjs'
            }, {
                width : '300',
                title : '事项明细',
                field : 'shixmx'
            },{
                width : '300',
                title : '进展',
                field : 'shixjzqk'
            },{
                width : '300',
                title : '验证情况',
                field : 'yanzqk'
            },{
                width : '300',
                title : '问题建议',
                field : 'czdwt'
            },{
                width : '80',
                title : '实际完成日期',
                field : 'shijwcsj'
            },{
                width : '80',
                title : '要求完成时间',
                field : 'yaoqwcsj'
            }] ],
            toolbar : '#toolbar',
            rowStyler:function(index,row){   
                if (row.lastname=='黄潇'){
                    return 'background-color:yellow;';   
                }   
            }
        });
        
        $('#userId').combotree({
            url: '${path }/oaflow/allUserTree',
            parentField : 'pid',
          	//选择树节点触发事件  
            onSelect : function(node) {  
                //返回树对象  
                //var tree = $(this).tree;  
                //选中的节点是否为叶子节点,如果不是叶子节点,清除选中  
                //var isLeaf = tree('iconCls', node.target);
                if (node.iconCls=='icon-folder') {  
                    //清除选中  
                    $('#userId').combotree('clear');  
                }  
            },
            onBeforeExpand:function(node) {
                $('#userId').combotree("tree").tree("options").url = "${path }/oaflow/allUserTree?departmentId=" + node.id;
         	}
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
                    <th>申请人:</th>
                    <td><select id="userId" name="userId" style="width: 140px; height: 29px;" class="easyui-validatebox" data-options="required:true"></select></td>
                    <th>申请日期:</th>
                    <td>
                    <input name="createdateStart" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly" />至<input  name="createdateEnd" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly" />
                    <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <div data-options="region:'center',border:true,title:'交接任务信息'" >
        <table id="dataGrid" data-options="fit:true,border:false"></table>
    </div>
    <div id="toolbar" style="display: none;">
    </div>
</body>
</html>