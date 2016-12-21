package com.yjxbi.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjxbi.commons.result.SingleQuery;
import com.yjxbi.commons.utils.PageInfo;
import com.yjxbi.service.ErpStatisticsService;

/**
 * @description：erp报表
 * @author：tukai
 * @date：2015/10/30 18:06
 */
@Controller
@RequestMapping("/erpstatistics")
public class ErpStatisticsController {

    @Autowired
    private ErpStatisticsService erpStatisticsService;


    @RequestMapping(value = "/single", method = RequestMethod.GET)
    public String single() {
        return "/erp/single";
    }

    @RequestMapping(value = "/singleGrid", method = RequestMethod.POST)
    @ResponseBody
    public PageInfo singleGrid(Integer page, Integer rows,SingleQuery query) {
        PageInfo pageInfo = new PageInfo(page, rows);
        Map<String, Object> condition = new HashMap<String, Object>();
        if (StringUtils.isNoneBlank(query.getCreatedateStart())) {
            condition.put("createdateStart", query.getCreatedateStart());
        }
        if (StringUtils.isNoneBlank(query.getOperationId())) {
            condition.put("operationId", query.getOperationId());
        }
        if (StringUtils.isNoneBlank(query.getTgId())) {
            condition.put("tgId", query.getTgId());
        }
        if (StringUtils.isNoneBlank(query.getFtcontractcode())) {
            condition.put("ftcontractcode", query.getFtcontractcode());
        }
        if (StringUtils.isNoneBlank(query.getFtcontractcode2())) {
            condition.put("ftcontractcode2", query.getFtcontractcode2());
        }
        if (StringUtils.isNoneBlank(query.getDeveloper())) {
            condition.put("developer", query.getDeveloper());
        }
        if (StringUtils.isNoneBlank(query.getPrincipal2())) {
            condition.put("principal2", query.getPrincipal2());
        }
        if (StringUtils.isNoneBlank(query.getKfpartId())) {
            condition.put("kfpartId", query.getKfpartId());
        }
        if (StringUtils.isNoneBlank(query.getMainregionId())) {
            condition.put("mainregionId", query.getMainregionId());
        }
        if (StringUtils.isNoneBlank(query.getContractypeId())) {
            condition.put("contractypeId", query.getContractypeId());
        }
        if (StringUtils.isNoneBlank(query.getCreatedateEnd())) {
            condition.put("createdateEnd", query.getCreatedateEnd());
        }
        if (StringUtils.isNoneBlank(query.getOrderby())) {
            condition.put("orderby", query.getOrderby());
        }
        if (StringUtils.isNoneBlank(query.getSelfagentId())) {
            condition.put("selfagentId", query.getSelfagentId());
        }
        if (StringUtils.isNoneBlank(query.getIszzkf())) {
            condition.put("iszzkf", query.getIszzkf());
        }
        if (StringUtils.isNoneBlank(query.getIsmockagentfeewithouttax())) {
            condition.put("ismockagentfeewithouttax", query.getIsmockagentfeewithouttax());
        }
        if (StringUtils.isNoneBlank(query.getTotalforeign())) {
            condition.put("totalforeign", query.getTotalforeign());
        }
        if (StringUtils.isNoneBlank(query.getJscustomer())) {
            condition.put("jscustomer", query.getJscustomer());
        }
        pageInfo.setCondition(condition);
        erpStatisticsService.querySingleList(pageInfo);
        erpStatisticsService.querySingleSum(pageInfo);
        BigDecimal mockagentfeewithouttax = erpStatisticsService.queryFeewithouttax(pageInfo);
        Map<String,String> showValue = new HashMap<String,String>();
        showValue.put("mockagentfeewithouttax", mockagentfeewithouttax.toString());
        pageInfo.setShowResult(showValue);
        return pageInfo;
    }
    
    @RequestMapping(value = "/operationList", method = RequestMethod.POST)
    @ResponseBody
    public Object tree() {
        return erpStatisticsService.queryOperationList();
    }
    
    @RequestMapping(value = "/jscustomerList", method = RequestMethod.POST)
    @ResponseBody
    public Object jscustomerList() {
        return erpStatisticsService.queryJsCustomerList();
    }
    
    @RequestMapping(value = "/stateList", method = RequestMethod.POST)
    @ResponseBody
    public Object stateList(String stateName) {
    	if(StringUtils.isBlank(stateName)) return null;
        return erpStatisticsService.queryStateListByName(stateName);
    }
    
    @RequestMapping("exportExcel")  
    public void exportExcel(HttpServletRequest request, HttpServletResponse response)  
    {  
        HttpSession session = request.getSession();  
        session.setAttribute("state", null);  
        // 生成提示信息，  
        response.setContentType("application/vnd.ms-excel");  
        String codedFileName = null;  
        OutputStream fOut = null;  
        try  
        {  
            // 进行转码，使其支持中文文件名  
            codedFileName = java.net.URLEncoder.encode("中文", "UTF-8");  
            response.setHeader("content-disposition", "attachment;filename=" + codedFileName + ".xls");  
            // response.addHeader("Content-Disposition", "attachment;   filename=" + codedFileName + ".xls");  
            // 产生工作簿对象  
            /*HSSFWorkbook workbook = new HSSFWorkbook();  
            //产生工作表对象  
            HSSFSheet sheet = workbook.createSheet();  
            for (int i = 0; i <= 30000; i++)  
            {  
                HSSFRow row = sheet.createRow((int)i);//创建一行  
                HSSFCell cell = row.createCell((int)0);//创建一列  
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);  
                cell.setCellValue("测试成功" + i);  
            }  
            fOut = response.getOutputStream();  
            workbook.write(fOut); */ 
        }  
        catch (UnsupportedEncodingException e1)  
        {}  
        catch (Exception e)  
        {}  
        finally  
        {  
            try  
            {  
                fOut.flush();  
                fOut.close();  
            }  
            catch (IOException e)  
            {}  
            session.setAttribute("state", "open");  
        }  
        System.out.println("文件生成...");  
    } 
}
