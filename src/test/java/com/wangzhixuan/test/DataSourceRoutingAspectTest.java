package com.wangzhixuan.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.wangzhixuan.test.base.BaseTest;
import com.yjxbi.commons.utils.PageInfo;
import com.yjxbi.service.ErpStatisticsService;
import com.yjxbi.service.SlaveService;

/**
 * @Description：DataSourceRoutingAspectTest
 * @author：tukai
 * @date：2015年8月19日 下午5:23:24
 */
public class DataSourceRoutingAspectTest extends BaseTest {

    @Autowired
    private SlaveService slaveService;
    
    @Autowired
    private ErpStatisticsService erpstatisticsserviceimpl;

    /**
     * 参考链接：Spring MVC测试框架详解——服务端测试
     * <URL>http://jinnianshilongnian.iteye.com/blog/2004660</URL>
     */

    @Test
    public void testFindAllShop() {
        //Integer count = slaveService.count();
        //System.out.println(count);
        PageInfo pageInfo = new PageInfo(1, 20);
        erpstatisticsserviceimpl.getPubConstants("111");
        /*List list = pageInfo.getRows();
        for(int i=0;i<list.size();i++){
        	HrmreSource source = (HrmreSource)list.get(i);
        	System.out.println(source.getRemark());
        }*/
        
    }
}

