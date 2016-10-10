package com.yjxbi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.yjxbi.commons.base.BaseController;

/**
 * @description：echartsController
 * @author：凃凯
 * @date：2016/9/26 14:51
 */
@Controller
@RequestMapping("/echarts")
public class EchartsDataController extends BaseController {

    @RequestMapping(value = "/areaDataGrid", method = RequestMethod.GET)
    public String areaDataGrid(Model model) {
        return "datashow/echartsData";
    }
    
    @RequestMapping(value = "/lineQueryData", method = RequestMethod.GET)
    public String lineQueryData(Model model) {
        return "datashow/echartsDataLine";
    }
    
    @RequestMapping(value = "/mapQueryData", method = RequestMethod.GET)
    public String mapQueryData(Model model) {
        return "datashow/echartsDatamap";
    }
    
    @RequestMapping(value = "/showLineData", method = RequestMethod.GET)
    @ResponseBody
    public String showLineData(Model model) {
    	String[] categories = {"鞋", "衬衫", "外套", "牛仔裤"};  
	    Integer[] values = {80, 50, 75, 100};  
	    Map<String, Object> map = new HashMap<String, Object>();  
	    map.put("categories", categories);  
        map.put("values", values);  
	    String json=JSON.toJSONString(map);
		return json;
    }
}
