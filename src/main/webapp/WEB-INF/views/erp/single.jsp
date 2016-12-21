<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/basejs.jsp" %>
<script type="text/javascript" src="${staticPath }/static/comboxexpand.js" charset="utf-8"></script>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工基本信息</title>
    <script type="text/javascript">

    var dataGrid;
    var organizationTree;

    $(function() {

        dataGrid = $('#dataGrid').datagrid({
            url : '',
            fit : true,
            striped : true,
            rownumbers : true,
            pagination : true,
            singleSelect : true,
            idField : 'id',
            onLoadSuccess:function(data){
            	$('#ftcamount').html(data.singletotalsum.totalrmbftcamountsum);
            	$('#busiamount').html(data.singletotalsum.totalrmbbusiamountsum);
            	$('#agentfee').html(data.singletotalsum.paymentofagentsum);
            	$('#mockagentfeewithouttax').html(data.showResult.mockagentfeewithouttax);
            	$('#getfee').html(data.singletotalsum.paymentofgetsum);
            	$('#ftcusdamount').html(data.singletotalsum.totalusdftcamountsum);
            	var typeData = data.totalList;
                $.each(typeData, function(i, n) {
                	var tbBody = "<tr><td>" + n.ftccurrency + "</td>" + "<td>" + n.totalShow + "</td>" + "</tr>";
                    $("#myTb").append(tbBody);
                });
                $("#createtable").append("</table>");
				$(this).datagrid('doCellTip',{'max-width':'300px','delay':500});
			},
            pageSize : 20,
            pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
            columns : [ [  {
                width : '150',
                title : '合同日期',
                field : 'customdate'
            },{
                width : '150',
                title : '系统合同编号',
                field : 'ftcontractcode'
            },{
                width : '150',
                title : '客户合同编号',
                field : 'ftcontractcode2'
            },{
                width : '100',
                title : '合同类型',
                field : 'contractype2value'
            },{
                width : '100',
                title : '代理自营',
                field : 'agentorself' 
            }, {
                width : '200',
                title : '结算客户',
                field : 'customername'
            },{
                width : '150',
                title : '是否业务自主开发',
                field : 'iszzkf'
            },{
                width : '150',
                title : '开发人',
                field : 'principal1'
            },{
                width : '200',
                title : '开发单位',
                field : 'developedept'
            },{
                width : '150',
                title : '商务主任',
                field : 'principal2no'
            },{
                width : '200',
                title : '经营单位',
                field : 'operationname'
            },{
                width : '200',
                title : '运作地',
                field : 'mainregion'
            },{
                width : '150',
                title : '币种',
                field : 'ftccurrency'
            },{
                width : '150',
                title : '运作量',
                field : 'operationamount'
            },{
                width : '150',
                title : '业务量',
                field : 'busiamount'
            },{
                width : '150',
                title : '代理费（RMB）',
                field : 'paymentofagent'
            },{
                width : '150',
                title : '不含税<br>代理费（RMB）',
                field : 'mockagentfeewithouttax2'
            },{
                width : '150',
                title : '税后毛利（RMB）',
                field : 'paymentofget'
            },{
                width : '150',
                title : '外汇额度',
                field : 'totalforeign'
            }] ],
            toolbar : '#toolbar'
        });
        
        $('#operationId').combotree({
            url: '${path }/erpstatistics/operationList',
            valueField: 'id',
            textField: 'text',
            panelHeight: 'auto',
            showDataSize : 10,
            editable: false
        });
        
        $('#jscustomer').combobox({
            url: '${path }/erpstatistics/jscustomerList',
            valueField: 'id',
            textField: 'text',
            panelHeight: 300,
            editable: true,
            hasDownArrow:false,
            showDataSize:20,
            filter: function(q, row){  
                var opts = $(this).combobox('options');  
                return row[opts.textField].indexOf(q) >= 0;//这里改成>=即可在任意地方匹配  
            }, 
        });
        
        $('#tgId').combotree({
            url: '${path }/erpstatistics/stateList?stateName=YN',
            valueField: 'id',
            textField: 'text',
            panelHeight: 'auto',
            editable: false
        });
        
        $('#kfpartId').combotree({
            url: '${path }/erpstatistics/stateList?stateName=DEPT',
            valueField: 'id',
            textField: 'text',
            panelHeight: 'auto',
            editable: false
        });
        
        $('#mainregionId').combotree({
            url: '${path }/erpstatistics/stateList?stateName=MAINREGION',
            valueField: 'id',
            textField: 'text',
            panelHeight: 'auto',
            editable: false
        });
        
        $('#contractypeId').combotree({
            url: '${path }/erpstatistics/stateList?stateName=CONTRACTYPE22',
            valueField: 'id',
            textField: 'text',
            panelHeight: 'auto',
            editable: false
        });
        
        $('#selfagentId').combotree({
            url: '${path }/erpstatistics/stateList?stateName=SELFAGENT',
            valueField: 'id',
            textField: 'text',
            panelHeight: 'auto',
            editable: false
        });
    });
    
    function searchFun() {
    	$('#ftcamount').empty();
    	$('#busiamount').empty();
    	$('#agentfee').empty();
    	$('#mockagentfeewithouttax').empty();
    	$('#getfee').empty();
    	$('#ftcusdamount').empty();
    	$("#myTb").empty();
    	var options = $('#dataGrid').datagrid('options');
    	options.url = '${path }/erpstatistics/singleGrid';
    	dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
    }
    
    function cleanFun() {
        $('#searchForm input').val('');
        $('#operationId').combotree("clear");
        //dataGrid.datagrid('load', {});
    }
    </script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
    <div data-options="region:'north',border:false" style="height: 330px; overflow: hidden;background-color: #fff">
        <form id="searchForm">
            <table>
                <tr>
                    <th width="100px;" align="right">经营单位:</th>
                    <td width="300px;"><select id="operationId" name="operationId" style="width: 250px; height: 25px;"></select></td>
                    <th width="100px;" align="right">是否通关:</th>
                    <td width="300px;"><select id="tgId" name="tgId" style="width: 250px; height: 25px;"></select></td>
                    <th width="100px;" align="right">系统合同编号:</th>
                    <td width="300px;"><input name="ftcontractcode" placeholder="请输入系统合同编号" style="width: 230px; height: 22px;"/></td>
                    <th width="100px;" align="right">客户合同编号:</th>
                    <td width="300px;"><input name="ftcontractcode2" placeholder="请输入客户合同编号" style="width: 230px; height: 22px;"/></td>
                </tr>
                <tr>
                    <th align="right">开发人:</th>
                    <td><input name="developer" placeholder="请输入开发人" style="width: 230px; height: 22px;"/></td>
                    <th align="right">商务主任:</th>
                    <td><input name="principal2" placeholder="请输入商务主任" style="width: 230px; height: 22px;"/></td>
                    <th align="right">开发单位:</th>
                    <td><select id="kfpartId" name="kfpartId" style="width: 250px; height: 25px;"></td>
                    <th align="right">合同运作地:</th>
                    <td><select id="mainregionId" name="mainregionId" style="width: 250px; height: 25px;"></td>
                </tr>
                <tr>
                	<th align="right">合同类别:</th>
                    <td><select id="contractypeId" name="contractypeId" style="width: 250px; height: 25px;"></td>
                    <th align="right">合同日期:</th>
                    <td>
                    	<input name="createdateStart" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly" />至<input  name="createdateEnd" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" readonly="readonly" />
                    </td>
                    <th align="right"><!-- 排序字段: --></th>
                    <td><!-- <select name="orderby" class="easyui-combobox" data-options="width:140,height:25,editable:false,panelHeight:'auto'">
                            <option value="" selected>--请选择--</option>
                            <option value="eaptftcont0_.customdate">合同日期</option>
                            <option value="eaptftcont1_.totalrmbftcamount">运作量</option>
                            <option value="eaptftcont1_.totalrmbbusiamount">业务量</option>
                            <option value="eaptftcont1_.paymentofagent">代理费金额</option>
                            <option value="eaptftcont1_.paymentofget">税后毛利</option>
                        </select> --></td>
                    <th align="right">代理/自营:</th>
                    <td><select id="selfagentId" name="selfagentId" style="width: 250px; height: 25px;"></td>
                </tr>
                <tr>
                	<th align="right">结算客户:</th>
                    <td><select id="jscustomer" name="jscustomer" class="easyui-combobox" style="width: 250px; height: 25px;"></select></td>
                    <th align="right">是否自主开发:</th>
                    <td><select name="iszzkf" class="easyui-combobox" data-options="width:140,height:25,editable:false,panelHeight:'auto'">
                            <option value="" selected>全部</option>
                            <option value="Y">是</option>
                            <option value="N">否</option>
                        </select></td>
                    <th align="right">合计不税代理费:</th>
                    <td><select name="ismockagentfeewithouttax" class="easyui-combobox" data-options="width:140,height:25,editable:false,panelHeight:'auto'">
                            <option value="Y" selected>是</option>
                            <option value="N">否</option>
                        </select></td>
                     <th align="right">进口外汇额度:</th>
                    <td><select name="totalforeign" class="easyui-combobox" data-options="width:140,height:25,editable:false,panelHeight:'auto'">
                            <option value="" selected>--请选择--</option>
                            <option value="G">大于零</option>
                            <option value="E">等于零</option>
                            <option value="L">小于零</option>
                        </select></td>
                </tr>
            </table>
        </form>
        <table>
            <tr>
            	<td valign="top" align="center" width="500px;">
            		<table border="1" cellspacing="0">
            			<tr>
            				<td colspan="2" align="center">总合计<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',plain:true" onclick="cleanFun();">清空</a></td>
            			</tr>
            			<tr>
            				<td width="150">运作量（RMB）</td>
            				<td width="150"><span id="ftcamount"></span></td>
            			</tr>
            			<tr>
            				<td>业务量（RMB）</td>
            				<td><span id="busiamount"></span></td>
            			</tr>
            			<tr>
            				<td>代理费（RMB）</td>
            				<td><span id="agentfee"></span></td>
            			</tr>
            			<tr>
            				<td>代理费(不含税)（RMB）</td>
            				<td><span id="mockagentfeewithouttax"></span></td>
            			</tr>
            			<tr>
            				<td>税后毛利（RMB）</td>
            				<td><span id="getfee"></span></td>
            			</tr>
            			<tr>
            				<td>运作量（USD）</td>
            				<td><span id="ftcusdamount"></span></td>
            			</tr>
            		</table>
            	</td>
            	<td width="200px;"></td>
            	<td valign="top">
            		<table id="myTb" border="1" cellspacing="0"></table>
            	</td>
            </tr>
        </table>
    </div>
    <div data-options="region:'center',border:true,title:'单笔运作统计'" >
        <table id="dataGrid" data-options="fit:true,border:false"></table>
    </div>
    <div id="toolbar" style="display: none;">
    </div>
</body>
</html>