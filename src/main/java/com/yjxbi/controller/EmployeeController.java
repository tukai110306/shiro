package com.yjxbi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjxbi.commons.base.BaseController;
import com.yjxbi.commons.utils.PageInfo;
import com.yjxbi.model.Employee;

/**
 * @description：echartsController
 * @author：凃凯
 * @date：2016/9/26 14:51
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController extends BaseController {

    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public String userinfo(Model model) {
        return "employee/baseinfo";
    }
    
    @RequestMapping(value = "/kqinfo", method = RequestMethod.GET)
    public String kqinfo(Model model) {
        return "employee/kqinfo";
    }
    
    @RequestMapping(value = "/djinfo", method = RequestMethod.GET)
    public String djinfo(Model model) {
        return "employee/djinfo";
    }
    
    @RequestMapping(value = "/cginfo", method = RequestMethod.GET)
    public String cginfo(Model model) {
        return "purchase/cginfo";
    }
    
    @RequestMapping(value = "/customerinfo", method = RequestMethod.GET)
    public String customerinfo(Model model) {
        return "customer/baseinfo";
    }
    
    @RequestMapping(value = "/customerdjinfo", method = RequestMethod.GET)
    public String customerdjinfo(Model model) {
        return "customer/djinfo";
    }
    
    @RequestMapping(value = "/userinfoGrid", method = RequestMethod.POST)
    @ResponseBody
    public Object userinfoGrid(Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows);
        List<Employee> list = new ArrayList<Employee>();
        Employee e1 = new Employee();
        e1.setName("张红霞");
        e1.setDeveloper("总经办");
        e1.setZhiwu("董事长");
        e1.setSex("女");
        e1.setJoinTime("2002-06-01");
        e1.setContract("");
        e1.setSchool("");
        e1.setMajor("");
        e1.setLevelTime("");
        e1.setEducation("大专");
        e1.setCode("120101196201292529");
        e1.setBirthday("1962-01-29");
        e1.setRegistered("河北天津");
        e1.setRegisteredType("外埠城镇");
        e1.setNation("汉");
        e1.setAddress("");
        e1.setTelphone("");
        e1.setPhone("");
        e1.setMarriage("已婚");
        list.add(e1);
        
        Employee e2 = new Employee();
        e2.setName("邢云庆");
        e2.setDeveloper("总经办");
        e2.setZhiwu("总经理");
        e2.setSex("男");
        e2.setJoinTime("2002-06-01");
        e2.setContract("");
        e2.setSchool("");
        e2.setMajor("");
        e2.setLevelTime("");
        e2.setEducation("本科");
        e2.setCode("150428197508060817");
        e2.setBirthday("1975-08-06");
        e2.setRegistered("广东省深圳罗湖区");
        e2.setRegisteredType("深户");
        e2.setNation("汉");
        e2.setAddress("");
        e2.setTelphone("13926553781");
        e2.setPhone("");
        e2.setMarriage("已婚");
        list.add(e2);
        
        Employee e3 = new Employee();
        e3.setName("李淑兰");
        e3.setDeveloper("总经办");
        e3.setZhiwu("总经理");
        e3.setSex("男");
        e3.setJoinTime("2002-06-01");
        e3.setContract("");
        e3.setSchool("");
        e3.setMajor("");
        e3.setLevelTime("");
        e3.setEducation("本科");
        e3.setCode("150428197508060817");
        e3.setBirthday("1975-08-06");
        e3.setRegistered("广东省深圳市龙岗区中心城鸿进花园C2-604");
        e3.setRegisteredType("深户");
        e3.setNation("汉");
        e3.setAddress("广东省深圳市龙岗区中心城鸿进花园C2-604");
        e3.setTelphone("13926553781");
        e3.setPhone("");
        e3.setMarriage("已婚");
        list.add(e3);
        
        Employee e4 = new Employee();
        e4.setName("钟林云");
        e4.setDeveloper("关务部");
        e4.setZhiwu("关务部经理");
        e4.setSex("男");
        e4.setJoinTime("2007-09-01");
        e4.setContract("SZ0003");
        e4.setSchool("广州航海高等专科学校");
        e4.setMajor("港航商务管理");
        e4.setLevelTime("2007-07");
        e4.setEducation("本科");
        e4.setCode("441426198407180010");
        e4.setBirthday("1984-07-18");
        e4.setRegistered("广州市黄埔区红山三路101号");
        e4.setRegisteredType("深户");
        e4.setNation("汉");
        e4.setAddress("");
        e4.setTelphone("13554992901");
        e4.setPhone("");
        e4.setMarriage("已婚");
        list.add(e4);
        
        
        pageInfo.setRows(list);
        pageInfo.setTotal(4);
        return pageInfo;
    }
    
    @RequestMapping(value = "/userkqGrid", method = RequestMethod.POST)
    @ResponseBody
    public Object userkqGrid(Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows);
        List<Employee> list = new ArrayList<Employee>();
        Employee e1 = new Employee();
        e1.setName("金晶");
        e1.setCode("26");
        e1.setAddress("白天");
        e1.setBirthday("0");
        e1.setContract("2");
        e1.setDeveloper("0");
        e1.setEducation("2");
        e1.setJoinTime("3");
        e1.setLevelTime("0");
        e1.setMajor("2");
        e1.setMarriage("1");
        e1.setNation("20");
        list.add(e1);
        
        Employee e2 = new Employee();
        e2.setName("黄潇");
        e2.setCode("45");
        e2.setAddress("白天");
        e2.setBirthday("0");
        e2.setContract("1");
        e2.setDeveloper("0");
        e2.setEducation("1");
        e2.setJoinTime("1");
        e2.setLevelTime("0");
        e2.setMajor("1");
        e2.setMarriage("1");
        e2.setNation("23");
        list.add(e2);
        
        Employee e3 = new Employee();
        e3.setName("吴美玲");
        e3.setCode("86");
        e3.setAddress("白天");
        e3.setBirthday("0");
        e3.setContract("0");
        e3.setDeveloper("0");
        e3.setEducation("1");
        e3.setJoinTime("0");
        e3.setLevelTime("0");
        e3.setMajor("1");
        e3.setMarriage("1");
        e3.setNation("23");
        list.add(e3);
        
        Employee e4 = new Employee();
        e4.setName("陈妍");
        e4.setCode("124");
        e4.setAddress("白天");
        e4.setBirthday("0");
        e4.setContract("0");
        e4.setDeveloper("0");
        e4.setEducation("1");
        e4.setJoinTime("0");
        e4.setLevelTime("0");
        e4.setMajor("1");
        e4.setMarriage("1");
        e4.setNation("23");
        list.add(e4);
        
        Employee e5 = new Employee();
        e5.setName("李非凡");
        e5.setCode("338");
        e5.setAddress("白天");
        e5.setBirthday("0");
        e5.setContract("1");
        e5.setDeveloper("3");
        e5.setEducation("1");
        e5.setJoinTime("0");
        e5.setLevelTime("1");
        e5.setMajor("1");
        e5.setMarriage("1");
        e5.setNation("20");
        list.add(e5);
        pageInfo.setRows(list);
        pageInfo.setTotal(5);
        return pageInfo;
        
    }
    
    @RequestMapping(value = "/userdjGrid", method = RequestMethod.POST)
    @ResponseBody
    public Object userdjGrid(Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows);
        List<Employee> list = new ArrayList<Employee>();
        Employee e1 = new Employee();
        e1.setName("李非凡");
        e1.setDeveloper("销售部");
        e1.setAddress("150");
        e1.setBirthday("865200120");
        e1.setCode("5768000.8");
        e1.setJoinTime("45856210");
        e1.setContract("819343910");
        list.add(e1);
        
        Employee e2 = new Employee();
        e2.setName("王森林");
        e2.setDeveloper("销售部");
        e2.setAddress("256");
        e2.setBirthday("52362512541");
        e2.setCode("204541064.61");
        e2.setJoinTime("526258412");
        e2.setContract("51836254129");
        list.add(e2);
        
        Employee e3 = new Employee();
        e3.setName("司徒竹云");
        e3.setDeveloper("市场部");
        e3.setAddress("126");
        e3.setBirthday("2563258745");
        e3.setCode("20343323.37");
        e3.setJoinTime("15636985");
        e3.setContract("2547621760");
        list.add(e3);
        pageInfo.setRows(list);
        pageInfo.setTotal(3);
        return pageInfo;
    }
    
    @RequestMapping(value = "/usercgGrid", method = RequestMethod.POST)
    @ResponseBody
    public Object usercgGrid(Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows);
        List<Employee> list = new ArrayList<Employee>();
        Employee e1 = new Employee();
        e1.setDeveloper("信息部");
        e1.setName("林海峰");
        e1.setAddress("电脑周边");
        e1.setBirthday("电脑");
        e1.setCode("25964");
        e1.setJoinTime("2016-09-06");
        e1.setContract("");
        list.add(e1);
        
        Employee e2 = new Employee();
        e2.setDeveloper("市场部");
        e2.setName("程步云");
        e2.setAddress("办公耗材");
        e2.setBirthday("打印机");
        e2.setCode("45627");
        e2.setJoinTime("2016-09-18");
        e2.setContract("");
        list.add(e2);
        
        Employee e3 = new Employee();
        e3.setDeveloper("行政部");
        e3.setName("程步云");
        e3.setAddress("办公文具");
        e3.setBirthday("笔纸");
        e3.setCode("560");
        e3.setJoinTime("2016-09-28");
        e3.setContract("");
        list.add(e3);
        
        Employee e4 = new Employee();
        e4.setDeveloper("行政部");
        e4.setName("程步云");
        e4.setAddress("办公文具");
        e4.setBirthday("笔纸");
        e4.setCode("560");
        e4.setJoinTime("2016-09-08");
        e4.setContract("");
        list.add(e4);
        
        Employee e5 = new Employee();
        e5.setDeveloper("市场部");
        e5.setName("程步云");
        e5.setAddress("办公耗材");
        e5.setBirthday("墨盒");
        e5.setCode("860");
        e5.setJoinTime("2016-09-14");
        e5.setContract("");
        list.add(e5);
        
        Employee e6 = new Employee();
        e6.setDeveloper("财务部");
        e6.setName("肖金胜");
        e6.setAddress("办公文具");
        e6.setBirthday("打印纸");
        e6.setCode("590");
        e6.setJoinTime("2016-09-23");
        e6.setContract("");
        list.add(e6);
        
        Employee e7 = new Employee();
        e7.setDeveloper("关务部");
        e7.setName("肖金胜");
        e7.setAddress("办公文具");
        e7.setBirthday("打印纸");
        e7.setCode("430");
        e7.setJoinTime("2016-09-24");
        e7.setContract("");
        list.add(e7);
        pageInfo.setRows(list);
        pageInfo.setTotal(7);
        return pageInfo;
    }
    
    @RequestMapping(value = "/customerinfoGrid", method = RequestMethod.POST)
    @ResponseBody
    public Object customerinfoGrid(Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows);
        List<Employee> list = new ArrayList<Employee>();
        Employee e1 = new Employee();
        e1.setName("安芙电子科技（上海）有限公司");
        e1.setDeveloper("安芙电子科技（上海）有限公司");
        e1.setZhiwu("上海市嘉定区菊园新区树屏路588弄51号2030室");
        e1.setSex("电子");
        e1.setJoinTime("2013-10-22");
        e1.setContract("KH201603167018");
        e1.setSchool("上海市嘉定区菊园新区树屏路588弄51号2030室");
        e1.setMajor("自有");
        e1.setLevelTime("350");
        e1.setEducation("100万");
        e1.setCode("17");
        e1.setBirthday("贸易商");
        e1.setRegistered("杨涌");
        e1.setRegisteredType("老客户");
        e1.setNation("");
        list.add(e1);
        
        Employee e2 = new Employee();
        e2.setName("安徽省创凯电子有限公司");
        e2.setDeveloper("安芙电子科技（上海）有限公司");
        e2.setZhiwu("安徽省寿县新桥国际产业园创凯科技园内");
        e2.setSex("液晶屏工厂教育");
        e2.setJoinTime("1905-07-03");
        e2.setContract("KH201603165747");
        e2.setSchool("深圳市宝安68区鸿辉工业园4号厂房4楼或委托人指定的其");
        e2.setMajor("自有");
        e2.setLevelTime("2万平方");
        e2.setEducation("2000万");
        e2.setCode("300");
        e2.setBirthday("终端工厂");
        e2.setRegistered("陈湘岚");
        e2.setRegisteredType("老客户");
        e2.setNation("其他公司");
        list.add(e2);
        
        Employee e3 = new Employee();
        e3.setName("艾朗特思电子（深圳）有限公司");
        e3.setDeveloper("艾朗特思电子（深圳）有限公司");
        e3.setZhiwu("深圳市福田区新洲路东深圳国际商会大厦1210");
        e3.setSex("电子");
        e3.setJoinTime("2012-08-27");
        e3.setContract("KH201603166879");
        e3.setSchool("深圳市南山区高新南五道9号金证科技大厦206室");
        e3.setMajor("租赁");
        e3.setLevelTime("300");
        e3.setEducation("50万");
        e3.setCode("22");
        e3.setBirthday("贸易商");
        e3.setRegistered("杨涌");
        e3.setRegisteredType("新客户");
        e3.setNation("办事处");
        list.add(e3);
        
        pageInfo.setRows(list);
        pageInfo.setTotal(3);
        return pageInfo;
    }
    
    @RequestMapping(value = "/customertgGrid", method = RequestMethod.POST)
    @ResponseBody
    public Object customertgGrid() {
        PageInfo pageInfo = new PageInfo(1, 100);
        List<Employee> list = new ArrayList<Employee>();
        Employee e1 = new Employee();
        e1.setName("YA0116-37482");
        e1.setDeveloper("深圳市威可特电子科技有限公司 ( V4 )");
        e1.setZhiwu("英捷迅");
        e1.setSex("深圳");
        e1.setJoinTime("进口");
        e1.setContract("代理");
        e1.setSchool("USD");
        e1.setMajor("深圳市威可特电子科技有限公司 ( V4 )");
        e1.setLevelTime("2016-10-09");
        e1.setEducation("英捷迅");
        e1.setCode("通达国际发展");
        list.add(e1);
        
        Employee e2 = new Employee();
        e2.setName("YA0116-37481");
        e2.setDeveloper("深圳市威可特电子科技有限公司 ( V4 )");
        e2.setZhiwu("英捷迅");
        e2.setSex("深圳");
        e2.setJoinTime("进口");
        e2.setContract("代理");
        e2.setSchool("USD");
        e2.setMajor("深圳市威可特电子科技有限公司 ( V4 )");
        e2.setLevelTime("2016-03-21");
        e2.setEducation("英捷迅");
        e2.setCode("通达国际发展");
        list.add(e2);
        
        pageInfo.setRows(list);
        pageInfo.setTotal(2);
        return pageInfo;
    }
    
    @RequestMapping(value = "/customerwlGrid", method = RequestMethod.POST)
    @ResponseBody
    public Object customerwlGrid() {
        PageInfo pageInfo = new PageInfo(1, 100);
        List<Employee> list = new ArrayList<Employee>();
        Employee e1 = new Employee();
        e1.setName("罗湖仓库");
        e1.setDeveloper("货柜A区026");
        e1.setZhiwu("电脑相关");
        e1.setSex("2016-05-09");
        list.add(e1);
        
        Employee e2 = new Employee();
        e2.setName("罗湖仓库");
        e2.setDeveloper("已出仓，送往笋岗");
        e2.setZhiwu("耗材");
        e2.setSex("2016-03-21");
        list.add(e2);
        
        pageInfo.setRows(list);
        pageInfo.setTotal(2);
        return pageInfo;
    }
    
    @RequestMapping(value = "/customerdjinfoGrid", method = RequestMethod.POST)
    @ResponseBody
    public Object customerdjinfoGrid(Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows);
        List<Employee> list = new ArrayList<Employee>();
        Employee e1 = new Employee();
        e1.setName("安芙电子科技（上海）有限公司");
        e1.setDeveloper("KH201603167018");
        e1.setZhiwu("上海市嘉定区菊园新区树屏路588弄51号2030室");
        e1.setSex("7");
        e1.setJoinTime("56981423");
        e1.setContract("3");
        e1.setSchool("2016");
        list.add(e1);
        
        Employee e2 = new Employee();
        e2.setName("安徽省创凯电子有限公司");
        e2.setDeveloper("KH201603165747");
        e2.setZhiwu("安徽省寿县新桥国际产业园创凯科技园内");
        e2.setSex("7");
        e2.setJoinTime("36258410");
        e2.setContract("4");
        e2.setSchool("2016");
        list.add(e2);
        
        Employee e3 = new Employee();
        e3.setName("艾朗特思电子（深圳）有限公司");
        e3.setDeveloper("KH201603166879");
        e3.setZhiwu("深圳市福田区新洲路东深圳国际商会大厦1210");
        e3.setSex("7");
        e3.setJoinTime("95841246");
        e3.setContract("8");
        e3.setSchool("2016");
        list.add(e3);
        
        pageInfo.setRows(list);
        pageInfo.setTotal(3);
        return pageInfo;
    }
}
